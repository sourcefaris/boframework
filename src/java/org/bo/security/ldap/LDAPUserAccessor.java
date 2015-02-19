package org.bo.security.ldap;

import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;

import org.bo.entity.User;
import org.bo.security.DefaultUserAccessor;
import org.bo.util.PropertyLooker;
import org.bo.util.StringUtils;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

public class LDAPUserAccessor extends DefaultUserAccessor {
	private LdapTemplate ldapTemplate;

	public boolean authenticate(String username, String password) {
		LdapContextSource ctxSource = new LdapContextSource();
		ctxSource.setUrl(PropertyLooker.get("ldap.url"));
		ctxSource.setUserDn(buildDn(username) + "," + PropertyLooker.get("ldap.base"));
		ctxSource.setPassword(password);
		ctxSource.setPooled(false);
		try {
			ctxSource.afterPropertiesSet();
			ctxSource.getReadWriteContext();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public void update(User userEdited) {
		super.update(userEdited);

		Attributes personAttributes = new BasicAttributes();
		BasicAttribute personBasicAttribute = new BasicAttribute("objectclass");
		personBasicAttribute.add("inetOrgPerson");
		personBasicAttribute.add("organizationalPerson");
		personBasicAttribute.add("person");
		personBasicAttribute.add("top");
	    personAttributes.put(personBasicAttribute);
	    personAttributes.put("cn", userEdited.getUsername());
	    personAttributes.put("uid", userEdited.getUsername());
	    personAttributes.put("givenname", userEdited.getName().getFirst());
	    personAttributes.put("sn", userEdited.getName().getLast());
	    personAttributes.put("userPassword", new StringUtils().decodeBase64(userEdited.getPassword()));
	    ldapTemplate.rebind(buildDn(userEdited), null, personAttributes);
	}

	public String buildDn(String username){
		return PropertyLooker.get("ldap.bind.filter").replaceAll("%s", username);
	}
	
	public String buildDn(User user){
		return buildDn(user.getUsername());
	}

	public void setLdapTemplate(LdapTemplate ldapTemplate) {
		this.ldapTemplate = ldapTemplate;
	}

}
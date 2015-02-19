package org.bo.security.ldap;

import org.bo.entity.User;
import org.bo.security.Name;
import org.springframework.ldap.core.ContextMapper;
import org.springframework.ldap.core.DirContextAdapter;

public class AttributesMapper implements ContextMapper {

	public Object mapFromContext(Object ctx) {
		DirContextAdapter context = (DirContextAdapter) ctx;
		User user = new User();
		user.setName(new Name());
		user.getName().setFirst(context.getStringAttribute("givenname"));
		user.setUsername(context.getStringAttribute("uid"));
		
		return user;
	}
	
}

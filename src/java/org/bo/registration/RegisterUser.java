package org.bo.registration;

import java.util.ArrayList;
import java.util.List;

import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.bo.LogInformation;
import org.bo.entity.Role;
import org.bo.entity.User;
import org.bo.security.Address;
import org.bo.security.Name;
import org.bo.security.UserAccessor;
import org.bo.security.UserAccessorAware;
import org.bo.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class RegisterUser extends RegistrationForm implements UserAccessorAware {
	private UserAccessor ua;
	private String username = "";
	private String password = "";
	private String cpassword = "";
	private String firstName = "";
	private String lastName = "";
	private Address address = new Address();
	private String email = "";
	private String srole = "ee";
	private StringUtils su = new StringUtils();
	private String recaptcha_challenge_field;
	private String recaptcha_response_field;
	private @Autowired
	ReCaptchaImpl reCaptcha;

	public String execute() {
		if (getUsername() == null || "".equals(getUsername())) {
			addActionError("Username is required");
		}
		List<User> users = (ArrayList<User>) persistence.getList("SELECT u FROM "
				+ User.class.getName() + " u WHERE u.username='"
				+ getUsername() + "'");
		if (!users.isEmpty()) {
			addActionError("User already exist!");
		}
		if(getEmail() == null || "".equals(getEmail())){
			addActionError("Email is required");
		}
		List<User> emails = (ArrayList<User>) persistence.getList("SELECT e FROM "
				+ User.class.getName() + " e WHERE e.email='" + getEmail()
				+ "'");
		if(!emails.isEmpty()){
			addActionError("An Email has been using by another account, please check again.");
		}

		if (getPassword() == null || "".equals(getPassword())) {
			addActionError("Password is required");
		}
		if (!getPassword().equals(getCpassword())) {
			addActionError("Retype password and confirm password");
		}
		if (getFirstName() == null || "".equals(getFirstName())) {
			addActionError("First name is required");
		}
		/* Open this comment to use recaptcha 
		reCaptcha = new ReCaptchaImpl();
		reCaptcha.setPrivateKey(get("captcha.private.key"));
		ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(
				ServletActionContext.getRequest().getRemoteAddr(),
				recaptcha_challenge_field, recaptcha_response_field);
		if (!reCaptchaResponse.isValid()) {
			addActionError("Not a good Captcha");
		}
		*/
		if (hasActionErrors()) {
			return INPUT;
		}
		String srole = get("application.role.default");
		Role role;
		System.out.println("ROLE = " + srole);
		if (srole != null && !"".equals(srole)) {
			role = (Role) persistence.getByUniqueField(Role.class, srole, "name");
		} else {
			role = null;
		}

		getUser().setUsername(getUsername());// StringUtils.encodeBase64
		getUser().setPassword(su.encodeBase64(getPassword()));
		getUser().setName(new Name());
		getUser().getName().setFirst(getFirstName());
		getUser().getName().setLast(getLastName());
		getUser().setEmail(getEmail());
		getUser().setAddress(getAddress());
		getUser().setRole(role);
		if (Boolean.parseBoolean(get("application.user.activation.mail"))) {
			getUser().setLogInformation(new LogInformation(null, 0));
		} else {
			getUser().setLogInformation(new LogInformation(null, 1));
		}
		ua.signup(getUser());

		if (Boolean
				.parseBoolean(get("application.registration.activation.mail"))) {
			try {
				new SendActMail().send(getUser());
			} catch (ResourceNotFoundException e) {
				e.printStackTrace();
			} catch (ParseErrorException e) {
				e.printStackTrace();
			} catch (MethodInvocationException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return SUCCESS;
	}

	/**
	 * @return the cpassword
	 */
	public String getCpassword() {
		return cpassword;
	}

	/**
	 * @param cpassword
	 *            the cpassword to set
	 */
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	public void setUserAccessor(UserAccessor ua) {
		this.ua = ua;
	}

	/**
	 * @return the srole
	 */
	public String getSrole() {
		return srole;
	}

	/**
	 * @param srole
	 *            the srole to set
	 */
	public void setSrole(String srole) {
		this.srole = srole;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getRecaptcha_challenge_field() {
		return recaptcha_challenge_field;
	}

	public void setRecaptcha_challenge_field(String recaptcha_challenge_field) {
		this.recaptcha_challenge_field = recaptcha_challenge_field;
	}

	public String getRecaptcha_response_field() {
		return recaptcha_response_field;
	}

	public void setRecaptcha_response_field(String recaptcha_response_field) {
		this.recaptcha_response_field = recaptcha_response_field;
	}

}

package org.bo.password;

import java.sql.Timestamp;

import org.bo.LogInformation;
import org.bo.entity.User;
import org.bo.security.UserAccessor;
import org.bo.security.UserAccessorAware;
import org.bo.util.StringUtils;

import com.opensymphony.xwork2.validator.annotations.FieldExpressionValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validation;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

@Validation
public class UpdatePassword extends PasswordForm implements UserAccessorAware {
	private StringUtils su = new StringUtils();
	private UserAccessor ua;

	@Validations(
			requiredStrings = {
					@RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "currPassword", message = "Your current password is empty"),
					@RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "newPassword", message = "Your new password is empty"),
					@RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "verifyPassword", message = "Verify your new password") }, 
			stringLengthFields = { 
					@StringLengthFieldValidator(fieldName = "newPassword", minLength = "3", message = "Password minimum 3 character") }, 
			fieldExpressions = { 
					@FieldExpressionValidator(fieldName = "verifyPassword", expression = "newPassword == verifyPassword", message = "Verify your new Password") })
	public String execute() {
		if (!getCurrentUser().getPassword().equalsIgnoreCase(
				su.encodeBase64(getCurrPassword()))) {
			addFieldError("currPassword", "Your current password is invalid");
		}
		if (hasErrors()) {
			return INPUT;
		}
		User user;
		LogInformation logInfo;

		user = getCurrentUser();
		logInfo = user.getLogInformation();

		logInfo.setActiveFlag(LogInformation.ACTIVE);
		logInfo.setLastUpdateBy(getCurrentUser().getId());
		logInfo.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));

		user.setPassword(su.encodeBase64(getNewPassword()));
		user.setLogInformation(logInfo);

		ua.update(user);

		return SUCCESS;
	}

	public void setUserAccessor(UserAccessor ua) {
		this.ua = ua;
	}

}

package com.validator;

import org.apache.log4j.Logger;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.model.DatabaseCredential;

public class DatabaseCredentialValidator implements Validator{
	
	private static final Logger logger = Logger.getLogger(DatabaseCredentialValidator.class);

	@Override
	public boolean supports(Class<?> clazz) {
		return DatabaseCredential.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		logger.debug("Inside databaseCredentialValidator....");
		if(target instanceof DatabaseCredential){
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "database_name", "database_name.required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "database_ip", "database_ip.required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "database_username", "database_username.required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "database_password", "database_password.required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "application_name", "application_name.required");
		}
		logger.debug("ValidationUtils : >>"+errors);
	}

}

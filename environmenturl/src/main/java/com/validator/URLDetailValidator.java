package com.validator;

import org.apache.log4j.Logger;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.model.URLData;

public class URLDetailValidator implements Validator{
	
	private static final Logger logger = Logger.getLogger(URLDetailValidator.class);

	@Override
	public boolean supports(Class<?> clazz) {
		return URLData.class.isAssignableFrom(clazz)
				;
	}

	@Override
	public void validate(Object object, Errors errors) {
		logger.debug("Inside URLDataValidator....");
		if(object instanceof URLData){
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,"envName", "envName.required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,"projectName", "projectName.required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,"moduleName", "moduleName.required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,"moduleLink", "moduleLink.required");
		}
		logger.debug("ValidationUtils : >>"+errors);
	}

}

package com.validator;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.model.TomcatData;

public class TomcatDataValidator implements Validator{

	private static final Logger logger = Logger.getLogger(TomcatDataValidator.class);
	
	public boolean supports(Class clazz) {
		return TomcatData.class.isAssignableFrom(clazz);
	}
	
	public void validate(Object object, Errors errors) {
		logger.debug("Inside TomcatDataValidator....");
		if(object instanceof TomcatData){
			TomcatData tomcatData = (TomcatData)object;
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tomcatName", "tomcatName.required");
			if(StringUtils.isEmpty(tomcatData.getTomcatPort()) && inValidPort(tomcatData.getTomcatPort()))
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,"tomcatPort", "tomcatPort.required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,"envName", "envName.required");
		}
		logger.debug("ValidationUtils : >>"+errors);
	}
	
	public boolean inValidPort(String msisdn){
		try{
			Integer.parseInt(msisdn);
		}catch(Exception exception){
			return true;
		}
		return false;
	}

}

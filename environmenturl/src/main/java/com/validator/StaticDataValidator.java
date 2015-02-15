package com.validator;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.model.StaticData;

public class StaticDataValidator implements Validator{

	private static final Logger logger = Logger.getLogger(StaticDataValidator.class);
	
	@Override
	public boolean supports(Class<?> clazz) {
		return StaticData.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		logger.debug("Inside StaticDataValidator....");
		if(target instanceof StaticData){
			StaticData staticData = (StaticData)target;
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "data_type", "data_type.required");
			if(StringUtils.isEmpty(staticData.getData_value()))
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,"data_value", "data_value.required");
		}
		logger.debug("ValidationUtils : >>"+errors);
	}

}

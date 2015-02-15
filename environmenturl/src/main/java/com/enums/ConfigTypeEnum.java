package com.enums;

public enum ConfigTypeEnum {
	ENVIRONMENT_NAME("ENVIRONMENT NAME"),
	MODULE_NAME("MODULE NAME"),
	MSISDN_OPERATON("MSISDN_OPERATON");
	
	private final String value;
    
	ConfigTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }
}

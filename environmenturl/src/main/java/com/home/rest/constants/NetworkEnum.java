package com.home.rest.constants;

public enum NetworkEnum {

	REST1(1),
	REST2(2),
	REST3(3);

	private final int value;
	
	NetworkEnum(int v) {
		value = v;
	}

	public int value() {
		return value;
	}

	public static NetworkEnum fromValue(int v) {
		for (NetworkEnum enumValue: NetworkEnum.values()) {
			if (enumValue.value == v) {
				return enumValue;
			}
		}
		throw new IllegalArgumentException(String.valueOf(v));
	}

}

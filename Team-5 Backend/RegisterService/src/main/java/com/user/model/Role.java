package com.user.model;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

public enum Role {
	@JsonEnumDefaultValue
	user,
	admin

}

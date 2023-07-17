package com.project.order.model;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

public enum OrderStatus {
	@JsonEnumDefaultValue
	Placed,
	Canceled,
	Delivered;

}

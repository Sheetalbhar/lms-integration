package com.trangile.lms.integration.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CorporateServiceMapping {

	private Integer id;
	private String serviceCode;
	private String serviceID;
	private String code;
	private Integer quota;
	private String serviceType;
	private Boolean isActive;

}

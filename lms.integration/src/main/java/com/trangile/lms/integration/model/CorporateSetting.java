package com.trangile.lms.integration.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CorporateSetting {
	
	private Integer id;
	@JsonProperty("ServiceCode") 
    private String serviceCode;
	
	@JsonProperty("SettingType") 
    private String settingType;
	
	@JsonProperty("SettingValue") 
    private String settingValue;

}

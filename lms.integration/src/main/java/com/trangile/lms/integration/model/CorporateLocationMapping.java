package com.trangile.lms.integration.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CorporateLocationMapping {
	private Integer id ;
	@JsonProperty("ServiceCode")
    private String serviceCode ;
	
	@JsonProperty("LocationID")
    private Integer locationID ;
	
	@JsonProperty("ConfigValue")
    private String configJson ;
}

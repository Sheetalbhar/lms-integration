package com.trangile.lms.integration.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
 public class TokenResponse {
	@JsonProperty("expires_in")
	private Integer expires_in;
	
	@JsonProperty("token_type")
    private String token_type;
    
    @JsonProperty("issued_at")
    private Integer issued_at;
    
    @JsonProperty("access_token")
    private String access_token;
	

}

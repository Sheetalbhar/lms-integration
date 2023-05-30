package com.trangile.lms.integration.capitalOnePartner;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CapitalOneConfiguration {
	 private String client_id;
     private String client_secret;
     private String grant_type;
     private String getTokenUrl;
     private String getKeyUrl;
     private String eligibilityUrl;
     private String usageUrl;
}

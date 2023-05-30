package com.trangile.lms.integration.capitalOnePartner;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
 public class EligibilityRequest {
	 private String eligibilityCheckInputType;
     private String eligibilityCheckInputValue;
     private String loungeId;
}

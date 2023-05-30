package com.trangile.lms.integration.capitalOnePartner;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EligibilityResponse {
	private String usageLifeCycleId;
    private Boolean isEligible;
    private Integer ineligibleReasonCode;
    private String ineligibleReasonMessage;
    private List<Offer> offers;

}

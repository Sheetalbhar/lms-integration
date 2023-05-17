package com.trangile.lms.integration.api;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Payment {
	
	private String referenceNo;
	private Boolean isPayment;
	private String chargeVisitors;
	private String chargeAmount;
	private Boolean needCardDetails;

}

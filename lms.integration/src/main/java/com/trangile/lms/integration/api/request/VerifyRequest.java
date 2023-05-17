package com.trangile.lms.integration.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor

public class VerifyRequest {
	private String culture;
    private String serviceCode;
    private String cardNo;
    private String locationID;
    private int primaryGuest;
    private int tokenType;

}

package com.trangile.lms.integration.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlazaCardInfo {
	
	private String gID;
    private String desc;
    private String cardNumber;
    private String titleID;
    private String title;
    private String givenName;
    private String familyName;
    private String email;
    private String activationDate;
    private String contactNumber;
    private String dOB;
    private String address;
    private String city;
    private String postalCode;
    private String countryID;
}

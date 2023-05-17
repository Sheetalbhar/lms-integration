package com.trangile.lms.integration.api.request;


import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class GetPlazaCardRequest {
	private String culture;
    private String locationID;
    private String cardNo;

}

package com.trangile.lms.integration.api.request;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class VoidRequest {
	private String culture;
    private String serviceCode;
    private String locationID;
    private String cardNo;
    private String orderID;
    private String receiptNumber;
    private String voidReason;

}

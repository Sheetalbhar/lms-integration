package com.trangile.lms.integration.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class PaymentInfoRequest {
	private String culture;
    private String locationID;
    private String cardNo;
    private String orderID;
    private String receiptNumber;
    private String paymentRecieptNumber;
    private String referenceNo;
    public Boolean needCardDetail;
    public int tokenType;
    private String cvv;
    private String expMonth;
    private String expYear;

}

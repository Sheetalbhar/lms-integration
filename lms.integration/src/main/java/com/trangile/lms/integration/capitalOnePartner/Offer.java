package com.trangile.lms.integration.capitalOnePartner;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Offer {
    private String offerType;
    private String offerDescription;
    private Integer offerCount;
    private String offerPaymentAmount;
    private String offerPaymentAmountCurrencyCode;

}

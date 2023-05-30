package com.trangile.lms.integration.capitalOnePartner;


import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsageRequest {
	public String usageLifeCycleId;
    public String totalPaymentAmount;
    public String totalPaymentAmountCurrencyCode;
    public String paymentTimestamp;
    public String receiptNumber;
    public List<OffersApplied> offersApplied;
}

package com.trangile.lms.integration.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class OrderPayment {
	private UUID orderPaymentID;
    private String orderID;
    private String receiptNumber;
    private Date createUTCDate;
    private String thirdPartyOrder;
    private BigDecimal payAmount;
    private String currencyCode;
    private Integer visitors;
    private Integer chargeVisitors;
    private String referenceNo;
}

package com.trangile.lms.integration.model;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class AIService {
	
	private String ServiceID;
    private String ServiceCode;
    private Boolean IsPrimary;
    private Integer Quota;
    private Boolean NeedPay;
    private String CurrencyCode;
    private BigDecimal Price;
    private Integer UsedQty;
    private String ReferenceNo;

}

package com.trangile.lms.integration.api;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class EvoucherData {
	private String guestName;
    private String referenceNumber;
    private String receiptNumber;
    private String orderDate;
    private String startTime;
    private String orderID;
    private String customerTypeName;
    private List<EvoucherService> services;

}

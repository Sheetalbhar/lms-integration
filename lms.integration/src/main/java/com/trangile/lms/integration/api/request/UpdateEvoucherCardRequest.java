package com.trangile.lms.integration.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class UpdateEvoucherCardRequest {
	  private String culture;
      private String eVoucherNo;
      private String locationID;
      private String receiptNo;
      private String orderID;
}

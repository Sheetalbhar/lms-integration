package com.trangile.lms.integration.api.request;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class SaveRequest {
	
	  private String culture;
      private String serviceCode;
      private String cardNo;
      private String clientID;
      private String clientName;
      private String cardID;
      private String cardName;
      private String locationID;
      private String serviceID;
      private String orderID;
      private String receiptNumber;
      private String serviceName;
      private int primary;
      private int additional;
      private String referenceNo;
      private List<BoardingPassInfoDto> boardingPassInfoDtos;

}

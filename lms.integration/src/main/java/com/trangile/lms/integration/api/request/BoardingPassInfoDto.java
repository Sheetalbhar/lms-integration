package com.trangile.lms.integration.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class BoardingPassInfoDto {
	private String boardingPassRecordID;
    private String airlineCode;
    private String name;
    private String flightNumber;
    private String toCity;
    private String fromCity;
    public Boolean isPrimary;
    public Boolean isChild;

}

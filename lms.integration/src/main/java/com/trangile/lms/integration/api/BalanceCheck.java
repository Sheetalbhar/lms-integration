package com.trangile.lms.integration.api;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BalanceCheck {
	private String detailID;
    private String service;
    private String desc;
    private Date expiry;
    private int quantity;
    private String balance;

}

package com.trangile.lms.integration.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetEvoucherCardResponse {
	private String result;
	private String  msg ;
	private EvoucherResponseData data;

}

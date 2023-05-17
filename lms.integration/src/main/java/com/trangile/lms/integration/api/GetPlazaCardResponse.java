package com.trangile.lms.integration.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class GetPlazaCardResponse {
	private String result;
	private String msg;
	private PlazaCardResponseData data;

}

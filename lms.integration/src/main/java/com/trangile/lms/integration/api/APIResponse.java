package com.trangile.lms.integration.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class APIResponse<T> {
	private String result;
	private String msg;

}
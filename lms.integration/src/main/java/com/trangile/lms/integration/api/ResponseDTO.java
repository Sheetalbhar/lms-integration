package com.trangile.lms.integration.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {
	private int status;
	private String message;
	private Object data;
	private String tag;

}

package com.trangile.lms.integration.common.util;

public class UnirestException extends Exception{
	private static final long serialVersionUID = -3714840499934575734L;

	public UnirestException(Exception e) {
		super(e);
	}

	public UnirestException(String msg) {
		super(msg);
	}
}

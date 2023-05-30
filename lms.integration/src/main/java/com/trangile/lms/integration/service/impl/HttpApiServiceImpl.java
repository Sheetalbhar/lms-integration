package com.trangile.lms.integration.service.impl;

import com.trangile.lms.integration.api.ResponseDTO;
import com.trangile.lms.integration.common.config.HttpMethod;
import com.trangile.lms.integration.common.util.UnirestException;
import com.trangile.lms.integration.service.HttpApiService;

public class HttpApiServiceImpl implements HttpApiService{

	@Override
	public ResponseDTO getResponseFromAPI(HttpMethod method, String url, String jsonParameter, Integer httpCode,
			String contentType, Boolean isTls12, Integer timeOut) throws UnirestException {
		// TODO Auto-generated method stub
		return null;
	}

}

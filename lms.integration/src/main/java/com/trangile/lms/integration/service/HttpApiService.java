package com.trangile.lms.integration.service;



import com.trangile.lms.integration.api.ResponseDTO;
import com.trangile.lms.integration.common.config.HttpMethod;
import com.trangile.lms.integration.common.util.UnirestException;

public interface HttpApiService {
	ResponseDTO getResponseFromAPI(HttpMethod method,String url,String jsonParameter,Integer httpCode,String contentType,Boolean isTls12,Integer timeOut) throws UnirestException;
//	ResponseDTO getResponseFromTokenAPI(String partnerId,String filetype,String api, String body,String token, String contentType) throws UnirestException;
	
//	 private static Method GetMethod(HttpMethod httpMethod)
//     {
//         switch (httpMethod)
//         {
//             case HttpMethod.GET:
//                 return Method.GET;
//             case HttpMethod.POST:
//                 return Method.POST;
//             case HttpMethod.PUT:
//                 return Method.PUT;
//             case HttpMethod.DELETE:
//                 return Method.DELETE;
//             case HttpMethod.HEAD:
//                 return Method.HEAD;
//             case HttpMethod.OPTIONS:
//                 return Method.OPTIONS;
//             case HttpMethod.PATCH:
//                 return Method.PATCH;
//             case HttpMethod.MERGE:
//                 return Method.MERGE;
//             default:
//                 return Method.POST;
//         }
//     }
}

package com.trangile.lms.integration.api;

import com.trangile.lms.integration.api.request.SaveRequest;
import com.trangile.lms.integration.api.request.VerifyRequest;
import com.trangile.lms.integration.api.request.VoidRequest;

public interface BaseApi {
	
	Response Verify(VerifyRequest verifyRequest);
    Response Save(SaveRequest saveRequest);
    Response Void(VoidRequest voidRequest);

}

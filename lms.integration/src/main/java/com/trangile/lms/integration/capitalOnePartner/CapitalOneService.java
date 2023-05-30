package com.trangile.lms.integration.capitalOnePartner;


import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.trangile.lms.integration.api.BaseApi;
import com.trangile.lms.integration.api.Response;
import com.trangile.lms.integration.api.request.SaveRequest;
import com.trangile.lms.integration.api.request.VerifyRequest;
import com.trangile.lms.integration.api.request.VoidRequest;
import com.trangile.lms.integration.property.Resource;
import com.trangile.lms.integration.property.ResponseMsg;

@Service
public class CapitalOneService implements BaseApi{
	@Autowired
	private CapitalOneRepository capitaOneRepository;

	@Override
	public Response Verify(VerifyRequest verifyRequest) {
		Response response = new Response();
		try {
			if ((verifyRequest.getCardNo() == null) || (verifyRequest.getLocationID()== null))
	        {
	            response.setMsg(Resource.ParameterError);
	            response.setResult(ResponseMsg.Fail);
	            return response;
	        }
	        else
	        {
	            String loungeID = capitaOneRepository.getLoungeID(verifyRequest.getLocationID());
	            
	            if (loungeID == null)
	            {
	                response.setMsg(Resource.ParameterError);
	                response.setResult(ResponseMsg.Fail);
	                return response;
	            }
	            String token= capitaOneRepository.getAccessToken();
	            if (token ==null)
	            {
	            	response.setMsg(Resource.ParameterError);
	                response.setResult(ResponseMsg.Fail);
	                return response;
	            }
	            String encryptionCardNo = capitaOneRepository.encryptionCardNo(verifyRequest.getCardNo(), token);
	            if (encryptionCardNo == null)
	            {
	            	response.setMsg(Resource.ParameterError);
	                response.setResult(ResponseMsg.Fail);
	                return response;
	            }
	            EligibilityResponse eligibilityResponse=capitaOneRepository.eligibility(token, encryptionCardNo, loungeID);
	            if (!eligibilityResponse.getIsEligible())
	            {
	                response.setMsg(eligibilityResponse.getIneligibleReasonMessage());
	                response.setResult(ResponseMsg.Fail);
	                return response;
	            }
	        }
			
		}catch (ParseException pe) {
			// TODO: handle exception
		}
		catch (Exception e) {
			// TODO: handle exception
		}
        
		
        return response;
	}

	@Override
	public Response Save(SaveRequest saveRequest) {
		Response response = new Response();
        if (saveRequest.getCardNo() ==null || saveRequest.getLocationID() ==null)
        {
        	response.setMsg(Resource.ParameterError);
            response.setResult(ResponseMsg.Fail);
            return response;
        }
        return response;
	}

	@Override
	public Response Void(VoidRequest voidRequest) {
		return null;
	}

}

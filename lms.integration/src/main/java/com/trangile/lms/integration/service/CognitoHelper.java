package com.trangile.lms.integration.service;

import java.util.HashMap;
import org.springframework.stereotype.Service;
import com.trangile.lms.integration.model.User;
import com.trangile.lms.integration.property.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.http.HttpStatusCode;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.cognitoidentityprovider.CognitoIdentityProviderClient;
import software.amazon.awssdk.services.cognitoidentityprovider.model.AuthFlowType;
import software.amazon.awssdk.services.cognitoidentityprovider.model.ChallengeNameType;
import software.amazon.awssdk.services.cognitoidentityprovider.model.InitiateAuthRequest;
import software.amazon.awssdk.services.cognitoidentityprovider.model.InitiateAuthResponse;

@Slf4j
@Service
public class CognitoHelper  {
	private static final CognitoIdentityProviderClient identityProviderClient;
	

	
	static {
		identityProviderClient = CognitoIdentityProviderClient.builder()
				//.credentialsProvider(getAwsCredentialProvider())
				.region(Region.AP_SOUTHEAST_1).build();
	}

	public HashMap<String, Object> validateUser(User user) {
		//System.out.println("accessKeyId: "+accessKeyId);
		log.info("======================= cognito :validateUser start=========================");
		HashMap<String, Object> result =  new HashMap<String, Object>();
		HashMap<String, String> params =  new HashMap<String, String>();
		params.put("USERNAME", user.getUsername());
		params.put("PASSWORD", user.getPassword());
		
		InitiateAuthRequest initiateAuthRequest = InitiateAuthRequest.builder().clientId(user.getClient_id())
				.authFlow(AuthFlowType.USER_PASSWORD_AUTH).authParameters(params).build();
		InitiateAuthResponse initiateAuthResponse = identityProviderClient.initiateAuth(initiateAuthRequest);
		if (ChallengeNameType.NEW_PASSWORD_REQUIRED.equals(initiateAuthResponse.challengeName())) {
//			UserVo userVo = new UserVo();
//			userVo.setUsername(initiateAuthResponse.challengeParameters().get("USER_ID_FOR_SRP"));
//			userVo.setClientId(ssoClientId);
//			userVo.setSession(initiateAuthResponse.session());
			result.put("code", ResponseCode.NEW_PASSWORD_REQUIRED);
			//result.put("userVo", userVo);
			return result;
		}
		if (initiateAuthResponse.challengeName() == null
				&& initiateAuthResponse.sdkHttpResponse().statusCode() == HttpStatusCode.OK) {
			result.put("code", ResponseCode.SUCCESS);
			result.put("token", initiateAuthResponse.authenticationResult());
		} else {
			result.put("code", ResponseCode.USER_LOGIN_ERROR);
		}
		log.info("======================= cognito :validateUser end=========================");
		return result;
	
		
	}

}

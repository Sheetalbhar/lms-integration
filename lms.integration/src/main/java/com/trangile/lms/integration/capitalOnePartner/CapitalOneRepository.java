package com.trangile.lms.integration.capitalOnePartner;

import com.trangile.lms.integration.common.config.Config;
import com.trangile.lms.integration.common.config.ConfigFile;
import com.trangile.lms.integration.common.config.ServiceCodeType;
import com.trangile.lms.integration.common.config.SettingType;
import com.trangile.lms.integration.common.util.CommonDateUtil;
import com.trangile.lms.integration.common.util.JsonUtils;
import com.trangile.lms.integration.model.TokenRequest;
import com.trangile.lms.integration.model.TokenResponse;
import com.trangile.lms.integration.service.CorporateService;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.net.ssl.HttpsURLConnection;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.http.client.ClientProtocolException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("capitalOneRepository")
public class CapitalOneRepository {
	public static String ClientName = "CapitalOne";
	@Autowired
	private CorporateService corporateService;

	@Resource
	private ConfigFile configurationFile;
	CapitalOneConfiguration capitalOneConfig;
	
	final SimpleDateFormat sdf = new SimpleDateFormat(CommonDateUtil.DATE_FORMAT_SEARCH);
	

	@PostConstruct
	public void initiate() {
		System.out.println("inside consturtor CapitalOneRepository-------------");
		String settingValue = configurationFile.readCorporateSetting(ServiceCodeType.CapitalOne, SettingType.Config);
		System.out.println("settingValue-----" + settingValue);
		if (settingValue != null) {
			capitalOneConfig = JsonUtils.parse(settingValue, CapitalOneConfiguration.class);
			System.out.println("config fetched in constructor============" + capitalOneConfig);
		}

	}

	public String getLoungeID(String locationID) {
		String capitalOneLocation = corporateService.getCorporateLocationMapping(ClientName, locationID);
		if (capitalOneLocation != null) {
			LoungeConfig loungeConfig = null;
			loungeConfig = JsonUtils.parse(capitalOneLocation, LoungeConfig.class);
			return loungeConfig.getLoungeID();
		}
		return null;
	}

	public String getAccessToken() throws ParseException {
		String accesstoken;
		String tokenString = corporateService.getCorporateSetting(ClientName, SettingType.Token);
		System.out.println("tokenString==========" + tokenString);
		TokenResponse tokenObj = new TokenResponse();
		if (tokenString != null) {
			tokenObj = converToken(tokenString);
			Date issueDate = sdf.parse(tokenObj.getIssueDate());
			Date expiryDate = DateUtils.addSeconds(issueDate, tokenObj.getExpires_in());
			if(expiryDate.compareTo(issueDate)>0) {
				if (capitalOneConfig != null) {
					String gettokenString = getToken();
					if (gettokenString != null) {
						tokenObj = converToken(gettokenString);
						corporateService.updateCorporateSetting(ClientName, SettingType.Token, gettokenString);
						return tokenObj.getToken_type() + " " + tokenObj.getAccess_token();
					}
				} else
					return null;
			}
			
			return tokenObj.getToken_type() + " " + tokenObj.getAccess_token();
		} else {
			if (capitalOneConfig != null) {
				String tokenStr = getToken();
				if (tokenStr != null) {
					tokenObj = converToken(tokenStr);
					corporateService.addCorporateSetting(ClientName, SettingType.Token, tokenStr);
					return tokenObj.getToken_type() + " " + tokenObj.getAccess_token();
				}
			} else
				return null;
		}
		return tokenString;
	}

	private String getToken() {
		 String response;
		 TokenRequest tokenRequest= new TokenRequest();
		 tokenRequest.setClient_id(capitalOneConfig.getClient_id());
		 tokenRequest.setClient_secret(capitalOneConfig.getClient_secret());
		 tokenRequest.setGrant_type(capitalOneConfig.getGrant_type());
		 String tokenJSON = JsonUtils.objectToJson(tokenRequest);
		 HashMap<String, String> tokenHashMap = JsonUtils.jsonToMap(tokenJSON,HashMap.class);
		 try {
			 
		 }
		catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	private TokenResponse converToken(String tokenString) {
		TokenResponse tokenResponse = new TokenResponse();
		tokenResponse = JsonUtils.parse(tokenString, TokenResponse.class);
		return tokenResponse;
	}

	public String encryptionCardNo(String cardNo, String token) {
		String encryptionCardNo;
		String RSAKeysString = corporateService.getCorporateSetting(ClientName, SettingType.PublicKey);
		RSAKeysResponse rsaKeys = new RSAKeysResponse();
		 if(RSAKeysString != null) {
			 rsaKeys = convertPublicKeys(RSAKeysString);
			 //expirydate
			 if(true) {
				 
			 }
		 }
		return null;
	}

	private RSAKeysResponse convertPublicKeys(String rSAKeysString) {
		RSAKeysResponse rsaKeys = new RSAKeysResponse();
        rsaKeys = JsonUtils.parse(rSAKeysString, RSAKeysResponse.class);
        return rsaKeys;
	}

	public EligibilityResponse eligibility(String token, String encryptionCardNo, String loungeID) {
		final CloseableHttpClient client = HttpClients.custom().build();
		EligibilityRequest eligibilityRequest= new EligibilityRequest();
        eligibilityRequest.setEligibilityCheckInputType(Config.CardNumber);
        eligibilityRequest.setEligibilityCheckInputValue(encryptionCardNo);
        eligibilityRequest.setLoungeId(loungeID);
       String jsonEligibility = JsonUtils.objectToJson(eligibilityRequest);
       HashMap<String, String> header = new HashMap<>();
       header.put("Authorization", token);
       header.put("Accept", "application/json;v=1");
       try {
    	   String response;
           //http request
           if(capitalOneConfig!=null){
           	String url = capitalOneConfig.getEligibilityUrl(); 
           	final StringEntity entity= new StringEntity(jsonEligibility, Config.APPLICATION_JSON);
           	CloseableHttpResponse httpResponse = null;
           	final HttpPost httpPost = new HttpPost(url);
           	httpPost.addHeader("Authorization", token);
           	httpPost.addHeader("Accept", "application/json;v=1");
           	httpPost.setEntity(entity);
           	httpResponse = client.execute(httpPost);  
           	if(httpResponse.getStatusLine().getStatusCode() == 200) {
           		
           		
           	}
           }
       }
           catch (ClientProtocolException e) {
			// TODO: handle exception
		}
           catch (IOException e) {
			// TODO: handle exception
		}
       catch (Exception e) {
		// TODO: handle exception
	}
       
		return null;
	}

	public TokenResponse getNewToken() {
		TokenResponse tokenResponse = new TokenResponse();
//		TokenRequest tokenRequest = new TokenRequest("bb07ecc6633d426693b0a159f51159db",
//				"d33cca59d523429f1166bb3d72674410", "client_credentials");
	       try {
	    	   ///new code starts-----------
	    	   String url = "https://api-it.capitalone.com/oauth2/token";
	    	   URL obj = new URL(url);
	    	   
	    	   Map<String, String> params = new LinkedHashMap<>();
	    	   params.put("client_id", capitalOneConfig.getClient_id());
	    	   params.put("client_secret", capitalOneConfig.getClient_secret());
	    	   params.put("grant_type", capitalOneConfig.getGrant_type());
	    	   StringBuilder postData = new StringBuilder();
	    	   for(Map.Entry<String, String> param : params.entrySet()) {
	    		   if(postData.length() != 0) postData.append('&');
	    		   postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
	   	        postData.append('=');
	   	        postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));   
	    	   }
	    	   System.out.println("postData-----"+postData);
	    	   byte[] postDataBytes = postData.toString().getBytes("UTF-8");
	    	   HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
	    	   con.setRequestMethod("POST");
	    	   con.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
	    	   con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	    	   // Send post request
	    	   con.setDoOutput(true);
	    	   DataOutputStream wr = new DataOutputStream(con.getOutputStream());
	   	       con.getOutputStream().write(postDataBytes);
	    	 // wr.writeBytes(urlParameters);
	    	   wr.flush();
	    	   wr.close();
	    	   int responseCode = con.getResponseCode();
	    	   System.out.println("\nSending 'POST' request to URL : " + url);
	    	   System.out.println("Post parameters : " + postData);
	    	   System.out.println("Response Code : " + responseCode);

	    	   if(con.getResponseCode() == 200) {
	    		   BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	    		   String inputLine;
	    		   StringBuffer response = new StringBuffer();
	    		    while ((inputLine = in.readLine()) != null) {
	    		    	response.append(inputLine);
	    		    	}
	    		    in.close();
	    		    //print result
	    		    System.out.println("Response----"+response.toString());
	    		    tokenResponse= JsonUtils.jsonToObject(response.toString(), TokenResponse.class);
	    		    Date currentTime = new Date();
	    		    
	    		    sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
	    		    String issueDate = sdf.format(currentTime);
	    		    tokenResponse.setIssueDate(issueDate);
	    		    System.out.println("GMT time: " + issueDate);
	    		 //   Date expiryDate = DateUtils.addSeconds((Date)issueDate, 1296000);
	    		    
	    		    System.out.println("tokenResponse----------"+tokenResponse);   
	    			   }else {
	    				   System.out.println("fail");
	    			   }
	    	   configurationFile.writeToCorporateSettings(ClientName,SettingType.Token,tokenResponse);
	    	   //new code ends 
//	    	   String jsonTokenRequest = JsonUtils.objectToJson(tokenRequest);
//	    	   System.out.println("jsonTokenRequest-------------"+jsonTokenRequest);
//	    	   CloseableHttpResponse httpResponse = null;
//          	final HttpPost httpPost = new HttpPost("https://api-it.capitalone.com/oauth2/token");
//          	//final StringEntity entity= new StringEntity(jsonTokenRequest);
//          	List<NameValuePair> body = new ArrayList<NameValuePair>();
//          	body.add(new BasicNameValuePair("client_id","bb07ecc6633d426693b0a159f51159db"));
//          	body.add(new BasicNameValuePair("client_secret","d33cca59d523429f1166bb3d72674410"));
//          	body.add(new BasicNameValuePair("grant_type","client_credentials"));
//          	httpPost.addHeader("Content-Type", "application/json");
//          	httpPost.setEntity(new UrlEncodedFormEntity(body));
//           	httpResponse = client.execute(httpPost);  
//           	if(httpResponse.getStatusLine().getStatusCode() == 200) {
//           		System.out.println("httpResponse=========="+httpResponse.getEntity());
//           		final String tokenResponseStr = EntityUtils.toString(httpResponse.getEntity());
//           		System.out.println("tokenResponseStr------------------"+tokenResponseStr);
//           	}
	       }catch (ClientProtocolException e) {
				// TODO: handle exception
			}
	           catch (IOException e) {
				// TODO: handle exception
			}
	       catch (Exception e) {
			// TODO: handle exception
		}
	       
	      
		return null;
	}

	
}

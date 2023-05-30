package com.trangile.lms.integration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.deser.impl.JavaUtilCollectionsDeserializers;
import com.trangile.lms.integration.common.util.CommonDateUtil;
import com.trangile.lms.integration.common.util.JsonUtils;
import com.trangile.lms.integration.model.CorporateSetting;
import com.trangile.lms.integration.model.TokenRequest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.apache.commons.lang3.time.DateUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



@SpringBootApplication
public class Application {

	public static void main(String[] args) throws java.text.ParseException {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		System.out.println("-----------------------");
		
		final Date currentTime = new Date();
		System.out.println("Date type ===="+currentTime);

		final SimpleDateFormat sdf =
		        new SimpleDateFormat(CommonDateUtil.DATE_FORMAT_SEARCH);

		// Give it to me in GMT time.
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		System.out.println("GMT time: " + sdf.format(currentTime));
		String date = sdf.format(currentTime);
		Date dateD = sdf.parse(date);
		System.out.println("dateD======="+dateD);
		Date expiryDate = DateUtils.addSeconds(dateD, 1296000);
		System.out.println("expiryDate===="+expiryDate);
		if(expiryDate.compareTo(dateD)>0) {
			System.out.println("inside=============");
			
			
		}
		
		// Give it to me in GMT time.
				sdf.setTimeZone(TimeZone.getTimeZone("IST"));
				System.out.println("IST time: " + sdf.format(currentTime));
				Date expiryDate1 =DateUtils.addSeconds(currentTime, 1296000);
				System.out.println("Expiry Date IST ::::"+expiryDate1);
		
		
		
		
		
		
			
			
//		int i = (int) new Date().getTime();
//		 System.out.println("Integer : " + i);
//		 
//		 final SimpleDateFormat formatter = new SimpleDateFormat(CommonDateUtil.DATE_FORMAT_SEARCH);
//		 String date =  formatter.format(new Date(1685420727));
//		 System.out.println("Int Date : " + new Date(i));
//		 System.out.println("String date : " + date);
			
			
		 //System.out.println("Long : "+ new Date().getTime());
//		 System.out.println("Long date : " + new Date(new Date().getTime()));
		 
//		 Integer n = 1618816252;
//		 Date newDate = new Date(n);
//		 System.out.println("Date Sheetal : "+newDate );
	//	String accesskey = context.getEnvironment().getProperty("aws.accessKeyId");
//		try {
//			ClassLoader classLoader = Application.class.getClassLoader();
//	        File file = new File(classLoader.getResource("CorporateSetting.json").getFile());
//	        if(file.exists()) {
//				System.out.println("file exists-----------------------");
//				JSONParser jsonParser = new JSONParser();
//				JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(file));
//				System.out.println("jsonArray ====="+jsonArray.toJSONString());
//				List<CorporateSetting> corporateSettingList = new ArrayList<CorporateSetting>();
//				corporateSettingList = JsonUtils.parse2List(jsonArray.toString(), CorporateSetting.class);
//				System.out.println("corporateSetting==="+corporateSettingList);
//				System.out.println("corporateSetting size==="+corporateSettingList.size());
//			
//			}
//	        
//		}catch (FileNotFoundException e) {
//            e.printStackTrace();
//      } catch (IOException e) {
//         e.printStackTrace();
//      } catch (ParseException e) {
//         e.printStackTrace();
//      }
//		TokenRequest tokenRequest = new TokenRequest("ClientId", "client_secret", "grant_type");
//		 String tokenJSON = JsonUtils.objectToJson(tokenRequest);
//		 System.out.println("tokenJSON=="+tokenJSON);
//		 HashMap<String, String> tokenHashMap = JsonUtils.jsonToMap(tokenJSON,Map.class);
//		 System.out.println("tokenHashMap=="+tokenHashMap);
		
			
	}
//	@Bean
//	   public RestTemplate getRestTemplate() {
//	      return new RestTemplate();
//	   }


	

}

package com.trangile.lms.integration.common.config;

import java.io.BufferedWriter;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.trangile.lms.integration.Application;
import com.trangile.lms.integration.common.util.JsonUtils;
import com.trangile.lms.integration.model.CorporateLocationMapping;
import com.trangile.lms.integration.model.CorporateSetting;
import com.trangile.lms.integration.model.TokenResponse;

@Component
public class ConfigFile {


	public String readCorporateSetting(String serviceCode, String serviceType){
		try {
		ClassLoader classLoader = Application.class.getClassLoader();
		File file = new File(classLoader.getResource("CorporateSetting.json").getFile());
	    JSONParser jsonParser = new JSONParser();
	    String settingValue = null;
			
	        List<CorporateSetting> corporateSettingList;
	        if(file.exists()) {
				System.out.println("file exists-----------------------");
				JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(file));
				System.out.println("jsonArray ====="+jsonArray.toJSONString());
				corporateSettingList = new ArrayList<CorporateSetting>();
				corporateSettingList = JsonUtils.parse2List(jsonArray.toString(), CorporateSetting.class);
				System.out.println("corporateSetting==="+corporateSettingList);
				System.out.println("corporateSetting size==="+corporateSettingList.size());
				for(CorporateSetting settingObj:corporateSettingList) {
					if(settingObj.getServiceCode().equals(serviceCode)  && settingObj.getSettingType().equals(serviceType)) {
						settingValue = settingObj.getSettingValue();
						return settingValue;
					}
				}
			return null;
			}
	        
		}catch (FileNotFoundException e) {
	        e.printStackTrace();
	  } catch (IOException e) {
	     e.printStackTrace();
	  } catch (ParseException e) {
	     e.printStackTrace();
	  }
		return null;
	}
	
	public String readCorporateLocationMapping(String serviceCode, String locationID){
		try {
			ClassLoader classLoader = Application.class.getClassLoader();
		    File file = new File(classLoader.getResource("CorporateSetting.json").getFile());
		    JSONParser jsonParser = new JSONParser();
		    String configValue;
	        List<CorporateLocationMapping> corporateLocMappingList;
	        if(file.exists()) {
				System.out.println("file exists-----------------------");
				JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(file));
				System.out.println("jsonArray ====="+jsonArray.toJSONString());
				corporateLocMappingList = new ArrayList<CorporateLocationMapping>();
				corporateLocMappingList = JsonUtils.parse2List(jsonArray.toString(), CorporateLocationMapping.class);
				System.out.println("corporateSetting==="+corporateLocMappingList);
				System.out.println("corporateSetting size==="+corporateLocMappingList.size());
				for(CorporateLocationMapping mappingObj:corporateLocMappingList) {
					if(mappingObj.getServiceCode().equals(serviceCode)  && mappingObj.getLocationID().equals(locationID)) {
						configValue = mappingObj.getConfigJson();
						return configValue;
					}
				}
				
			return null;
			}
	        
		}catch (FileNotFoundException e) {
	        e.printStackTrace();
	  } catch (IOException e) {
	     e.printStackTrace();
	  } catch (ParseException e) {
	     e.printStackTrace();
	  }
		return null;
	}
	
	public Object writeToCorporateSettings(String serviceCode, String settingType, TokenResponse tokenResponse) throws IOException{
		String tokenJson = JsonUtils.objectToJson(tokenResponse);
		JSONObject corporateSettingJson = new JSONObject();
		corporateSettingJson.put("ServiceCode", serviceCode);  
		corporateSettingJson.put("SettingType", settingType);
		corporateSettingJson.put("SettingValue", tokenJson);
		Gson gson =new Gson();
		
		try {
			// Writing to a file  
			ClassLoader classLoader = Application.class.getClassLoader();
		//	File file = new File(classLoader.getResource("corporateSetting.json").getFile());
			//File file = new File("ThirdPartyAPILog/corporateSetting.json");
			FileWriter fileWriter = new FileWriter("ThirdPartyAPILog/corporateSetting.json"); 
			fileWriter.append(corporateSettingJson.toString());
			fileWriter.close();
			
//			if(file.exists()) {
//				//System.out.println("Writing JSON object to file-------------");
//				//gson.toJson(corporateSettingJson, new FileWriter(file));
//				FileWriter fileWriter = new FileWriter("d://jsonFile.json"); 
//				System.out.println("Writing JSON object to file-------------");
//				//BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
//				//writer.append("helloooo=====");
//				//fileWriter.write("hello--------------------------");
//				fileWriter.write("hellooooo");
//	            //fileWriter.flush();  
//	            fileWriter.close();
//	            System.out.println("data written into file-------------");
//			}else {
//				System.out.println("file not found------------");
//			}
			
		}catch (FileNotFoundException e) {
	        e.printStackTrace();
	  } catch (IOException e) {
	     e.printStackTrace();
	  } 
		return null;
	}
	
}

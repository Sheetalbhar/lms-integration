package com.trangile.lms.integration.model;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CorporateSetting {
	
	private Integer id;
	@JsonProperty("ServiceCode") 
    private String serviceCode;
	
	@JsonProperty("SettingType") 
    private String settingType;
	
	@JsonProperty("SettingValue") 
    private String settingValue;
	
	public JSONObject getJSONObject() {
        JSONObject obj = new JSONObject();
        try {
            obj.put("ServiceCode", serviceCode);
            obj.put("SettingType", settingType);
            obj.put("SettingValue", settingValue);
        } catch (Exception e) {
           System.out.println("DefaultListItem.toString JSONException: "+e.getMessage());
        }
        return obj;
    }

}

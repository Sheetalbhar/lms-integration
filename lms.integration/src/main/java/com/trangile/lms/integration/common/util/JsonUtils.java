package com.trangile.lms.integration.common.util;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;



import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JsonUtils {
	
	 private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	 static {
	        OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
	        OBJECT_MAPPER.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
	        OBJECT_MAPPER.setTimeZone(TimeZone.getDefault());
	        OBJECT_MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	    }
	 
	 public static <T> T jsonToObject(String json, Class<T> type)  {
	        ObjectMapper mapper = new ObjectMapper();
	        try {
	            T data = mapper.readValue(json, type);
	            return data;
	        } catch (Exception e) {
	            e.printStackTrace();
	           
	        }
			return null;
	    }
	 public static String objectToJson(Object obj) {
	        ObjectMapper mapper = new ObjectMapper();

	        try {
	            return mapper.writeValueAsString(obj);
	        } catch (JsonProcessingException e) {
	            e.printStackTrace();
	            
	        }
			return null;
	    }
	 
//	 public static String encodeFileToBase64Binary(File file) throws IOException {
//	        byte[] encoded = Base64.getEncoder().encode(FileUtils.readFileToByteArray(file));
//	        return new String(encoded, StandardCharsets.US_ASCII);
//	    }
	 
	// Json serialization
	 public static String stringify(Object obj) {
	        try {
	            return OBJECT_MAPPER.writeValueAsString(obj);
	        } catch (JsonProcessingException e) {
	            throw new RuntimeException(e);
	        }
	    }
	 
	 //Json deserialization
	 public static <T> T parse(String json, Class<T> clazz) {
	        try {
	            return OBJECT_MAPPER.readValue(json, clazz);
	        } catch (IOException e) {
	            throw new RuntimeException(e);
	        }
	    }
	 
	 //Deserialize Json to List
	 public static <T> List<T> parse2List(String json, Class<T> clazz) {
	        try {
	            JavaType javaType = OBJECT_MAPPER.getTypeFactory().constructParametricType(List.class, clazz);
	            return OBJECT_MAPPER.readValue(json, javaType);
	        } catch (IOException e) {
	            throw new RuntimeException(e);
	        }
	    }
	 //Convert JSON to Map
	public static <T> HashMap<String, String> jsonToMap(String tokenJSON, Class<T> clazz) {
//		try {
//			ObjectMapper mapper = new ObjectMapper();  
//            JavaType javaType = OBJECT_MAPPER.getTypeFactory().constructParametricType(Map.class, clazz);
//            return OBJECT_MAPPER.readValue(tokenJSON, new TypeReference< Map<String, String> >());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
		return null;
	}
	
	
	
	 
	 
}

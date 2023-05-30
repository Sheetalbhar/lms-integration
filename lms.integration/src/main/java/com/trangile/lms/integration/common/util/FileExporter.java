package com.trangile.lms.integration.common.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.trangile.lms.integration.model.ThirdPartyAPILog;

import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

public class FileExporter {
	
	public static void convertToCSV(HttpServletResponse response ,List<ThirdPartyAPILog> logList) throws IOException {
		System.out.println("*inside convertToCsv------------");
		
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String timeStamp =dateFormat.format(new Date());
		String filename = "log_"+timeStamp+".csv";			
		response.setContentType("text/csv");  
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename="+filename;
        response.setHeader(headerKey, headerValue);
        
       
	ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
			CsvPreference.STANDARD_PREFERENCE);
        String header[] = {"ID","APIType","Requested URL","Requested Date",
			"HeaderData","Requested JSON",
			"response JSON","HTTP Status Code","Exception Message"};
	
	String[] fieldMapping = {"logID","apiType","requestURL","requestDate",
			"headerData","requestJSON",
			".responseJSON","httpStatusCode","exceptionMessage"};
	System.out.println("*inside header------------"+header);
	csvWriter.writeHeader(header);
	for (ThirdPartyAPILog obj : logList) {
        csvWriter.write(obj, fieldMapping);
    }
     
    csvWriter.close();
    
    System.out.println("*closing ----------");
	}
	public String escapeSpecialCharacters(String data) {
	    String escapedData = data.replaceAll("\\R", " ");
	    if (data.contains(",") || data.contains("\"") || data.contains("'")) {
	        data = data.replace("\"", "\"\"");
	        escapedData = "\"" + data + "\"";
	    }
	    return escapedData;
	}
	public static void main(String[] args) throws IOException {
		
		try {
		      FileWriter myWriter = new FileWriter("d://filename.json");
		      myWriter.write("Files in Java might be tricky, but it is fun enough!");
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
//	//public void exportToCSV(List<ThirdPartyAPILog> logList) {
//		System.out.println("Creating CSV---------------");
//		HttpServletResponse response =new HttpServletResponseWrapper(null);
//		
//		 List<ThirdPartyAPILog> logList = new ArrayList<>();
//			logList.add(new ThirdPartyAPILog(UUID.randomUUID(), "POST","Requested URL"
//					, new Date(), "Header", "req Json", "res Json", 200, "Exception 1"));
//			logList.add(new ThirdPartyAPILog(UUID.randomUUID(), "GET","Requested URL"
//					, new Date(), "Header", "req Json", "res Json", 300, "Exception 2"));
//			logList.add(new ThirdPartyAPILog(UUID.randomUUID(), "PUT","Requested URL"
//					, new Date(), "Header", "req Json", "res Json", 100, "Exception 3"));
//			System.out.println("*inside logList------------"+logList);
//			//convertToCSV(response,logList);
			
	}

}

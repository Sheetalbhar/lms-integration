package com.trangile.lms.integration.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.trangile.lms.integration.common.config.ConfigFile;
import com.trangile.lms.integration.model.CorporateServiceMapping;
import com.trangile.lms.integration.model.OrderPayment;
import com.trangile.lms.integration.service.CorporateService;


@Service("corporateService")
public class CorporateServiceImpl implements CorporateService{
	
	@Resource
	private ConfigFile configFile;

	@Override
	public void addCorporateSetting(String ServiceCode, String SettingType, String SettingValue) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean updateCorporateSetting(String serviceCode, String settingType, String settingValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCorporateSetting(String serviceCode, String serviceType) {
		//configFile = new ConfigFile();
		String configValue = configFile.readCorporateSetting(serviceCode,serviceType);
		System.out.println("configValue-----"+configValue);
		return configValue;
	}

	@Override
	public String getCorporateLocationMapping(String serviceCode, String locationID) {
		String configValue = configFile.readCorporateLocationMapping(serviceCode,locationID);
		System.out.println("configValue-----"+configValue);
		return configValue;
	}

	@Override
	public List<CorporateServiceMapping> getCorporateServiceMappings(String serviceCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CorporateServiceMapping getCorporateServiceMapping(String serviceCode, String serviceID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addOrderPayment(OrderPayment orderPayment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OrderPayment getOrderPayment(String receiptNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean updateOrderPayment(OrderPayment orderPayment) {
		// TODO Auto-generated method stub
		return null;
	}
	

	

}

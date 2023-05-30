package com.trangile.lms.integration.service;

import java.util.List;

import com.trangile.lms.integration.model.CorporateServiceMapping;
import com.trangile.lms.integration.model.OrderPayment;


public interface CorporateService {
	void addCorporateSetting(String ServiceCode, String SettingType, String SettingValue);
    Boolean updateCorporateSetting(String ServiceCode, String SettingType, String SettingValue);
    String getCorporateSetting(String ServiceCode, String ServiceType);
    String getCorporateLocationMapping(String ServiceCode, String LocationID);
    List<CorporateServiceMapping> getCorporateServiceMappings(String serviceCode);
    CorporateServiceMapping getCorporateServiceMapping(String serviceCode, String serviceID);
    void addOrderPayment(OrderPayment orderPayment);
    OrderPayment getOrderPayment(String receiptNumber);
    Boolean updateOrderPayment(OrderPayment orderPayment);
}

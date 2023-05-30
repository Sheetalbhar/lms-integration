package com.trangile.lms.integration.api;

import java.util.List;
import com.trangile.lms.integration.model.AIService;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseData {
	 private List<AIService> aiServices;
	 private Payment payment;
}

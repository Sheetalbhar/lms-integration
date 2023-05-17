package com.trangile.lms.integration.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class EvoucherService {
	private String serviceName;
    private String serviceID;
    private int maxArrivalTime;
    private int minArrivalTime;
    private String onlineServiceConfigID;
    private String duration;

}

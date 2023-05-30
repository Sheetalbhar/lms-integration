package com.trangile.lms.integration.model;

import java.util.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThirdPartyAPILog {

	private UUID logID;
    private String apiType;
    private String requestURL;
    private Date requestDate;
    private String headerData;
    private String requestJSON;
    private String responseJSON;
    private Integer httpStatusCode;
    private String exceptionMessage;
}

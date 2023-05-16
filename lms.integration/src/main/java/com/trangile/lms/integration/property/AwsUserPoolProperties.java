package com.trangile.lms.integration.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
@ConfigurationProperties(prefix = "aws.user.pool")
public class AwsUserPoolProperties {
	private String staffHqUser;
    private String partnerUser;
    private String consumerUser;

}

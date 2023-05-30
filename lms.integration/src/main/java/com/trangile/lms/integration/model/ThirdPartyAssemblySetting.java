package com.trangile.lms.integration.model;



import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ThirdPartyAssemblySetting {

	private String AssemblyName;
    private String ServiceName;
    private String RepositoryName;
    private String ServiceCode;
}

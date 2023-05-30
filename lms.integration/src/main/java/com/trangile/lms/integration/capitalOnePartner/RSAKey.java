package com.trangile.lms.integration.capitalOnePartner;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RSAKey {
	private String kid;
    private String use;
    private String n;
    private String kty;
    private int exp;
    private String alg;
    private String productId;
    private String e;
}

package com.trangile.lms.integration.capitalOnePartner;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RSAKeysResponse {
	 private List<RSAKey> keys;

}

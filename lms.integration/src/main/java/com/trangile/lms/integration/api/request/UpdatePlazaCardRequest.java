package com.trangile.lms.integration.api.request;

import java.util.List;
import com.trangile.lms.integration.api.BalanceCheck;
import com.trangile.lms.integration.api.PlazaCardInfo;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class UpdatePlazaCardRequest {
    private String culture;
    private String locationID;
    private String userID;

    public PlazaCardInfo cardInfo;
    public List<BalanceCheck> balanceChecks;

}

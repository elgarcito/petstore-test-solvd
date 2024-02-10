package com.solvd;

import com.solvd.api.GetUserLoginMethod;
import com.solvd.api.GetUserLogoutMethod;
import com.solvd.api.domain.UserLogin;
import com.zebrunner.carina.api.apitools.validation.JsonComparatorContext;
import com.zebrunner.carina.core.IAbstractTest;
import org.testng.annotations.Test;

public class LoginTest implements IAbstractTest {
    @Test
    public void verifySuccessfulLogin() {
        UserLogin userLogin = new UserLogin("thename", "thepass");
        GetUserLoginMethod getUserLoginMethod = new GetUserLoginMethod(userLogin.getUserName(), userLogin.getPassword());

        getUserLoginMethod.callAPI();

        JsonComparatorContext comparatorContext = JsonComparatorContext.context();
        getUserLoginMethod.validateResponse(comparatorContext);
    }

    @Test
    public void verifySuccessfulLogout() {
        UserLogin userLogin = new UserLogin("thename", "thepass");
        GetUserLoginMethod getUserLoginMethod = new GetUserLoginMethod(userLogin.getUserName(), userLogin.getPassword());

        getUserLoginMethod.callAPI();

        GetUserLogoutMethod getUserLogoutMethod = new GetUserLogoutMethod();

        getUserLogoutMethod.callAPI();

        JsonComparatorContext comparatorContext = JsonComparatorContext.context();
        getUserLogoutMethod.validateResponse(comparatorContext);
    }
}

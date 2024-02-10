package com.solvd;

import com.solvd.api.GetUserLoginMethod;
import com.solvd.api.GetUserLogoutMethod;
import com.solvd.api.PostCreateUserMethod;
import com.solvd.api.domain.User;
import com.zebrunner.carina.api.apitools.validation.JsonComparatorContext;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.annotations.Test;

public class LoginTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "lucasp149")
    public void verifySuccessfulLogin() {
        User userLogin = new User();
        userLogin.setUserName("thename");
        userLogin.setPassword("thepass");
        GetUserLoginMethod getUserLoginMethod = new GetUserLoginMethod(userLogin.getUserName(), userLogin.getPassword());

        getUserLoginMethod.callAPI();

        JsonComparatorContext comparatorContext = JsonComparatorContext.context();
        getUserLoginMethod.validateResponse(comparatorContext);
    }

    @Test
    @MethodOwner(owner = "lucasp149")
    public void verifySuccessfulLogout() {
        User userLogin = new User();
        userLogin.setUserName("thename");
        userLogin.setPassword("thepass");
        GetUserLoginMethod getUserLoginMethod = new GetUserLoginMethod(userLogin.getUserName(), userLogin.getPassword());

        getUserLoginMethod.callAPI();

        GetUserLogoutMethod getUserLogoutMethod = new GetUserLogoutMethod();

        getUserLogoutMethod.callAPI();

        JsonComparatorContext comparatorContext = JsonComparatorContext.context();
        getUserLogoutMethod.validateResponse(comparatorContext);
    }

    @Test
    @MethodOwner(owner = "lucasp149")
    public void verifyCreateUser () {
        PostCreateUserMethod postCreateUserMethod = new PostCreateUserMethod();
        postCreateUserMethod.setProperties("api/user/user.properties");

        postCreateUserMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        postCreateUserMethod.callAPI();

        JsonComparatorContext comparatorContext = JsonComparatorContext.context();
        postCreateUserMethod.validateResponse(comparatorContext);
    }

}

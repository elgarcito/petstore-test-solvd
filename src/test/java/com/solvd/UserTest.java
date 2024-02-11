package com.solvd;

import com.solvd.api.*;
import com.solvd.api.domain.User;
import com.zebrunner.carina.api.apitools.validation.JsonComparatorContext;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.annotations.Test;

public class UserTest extends AbstractTest {

    @MethodOwner(owner = "sebafermanelli")
    @Test(description = "Deletes a user that does not exist", priority = 1)
    public void testInvalidDeleteUser() {
        User user = new User();
        user.setUserName("ThisIsUserName");

        DeleteUserMethod deleteUser = new DeleteUserMethod(user.getUserName());
        deleteUser.expectResponseStatus(HttpResponseStatusType.NOT_FOUND_404);
        deleteUser.callAPI();
    }

    @MethodOwner(owner = "lucasp149")
    @Test(description = "Create a new user with the user.properties", priority = 2)
    public void verifyCreateUser() {
        PostCreateUserMethod postCreateUserMethod = new PostCreateUserMethod();
        postCreateUserMethod.setProperties("api/user/user.properties");

        postCreateUserMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        postCreateUserMethod.callAPI();

        JsonComparatorContext comparatorContext = JsonComparatorContext.context();
        postCreateUserMethod.validateResponse(comparatorContext);
    }

    @MethodOwner(owner = "sebafermanelli")
    @Test(description = "Verify if the username provided is a valid user", priority = 3)
    public void testValidGetUserByUsername() {
        User user = new User();
        user.setUserName("ThisIsUserName");
        GetUserMethod getUser = new GetUserMethod(user.getUserName());

        getUser.expectResponseStatus(HttpResponseStatusType.OK_200);
        getUser.callAPI();

        JsonComparatorContext comparatorContext = JsonComparatorContext.context();
        getUser.validateResponse(comparatorContext);
    }

    @MethodOwner(owner = "lucasp149")
    @Test(description = "Verify if the username and password provided is valid", priority = 4)
    public void verifySuccessfulLogin() {
        User userLogin = new User();
        userLogin.setUserName("thename");
        userLogin.setPassword("thepass");
        GetUserLoginMethod getUserLoginMethod = new GetUserLoginMethod(userLogin.getUserName(), userLogin.getPassword());

        getUserLoginMethod.callAPI();

        JsonComparatorContext comparatorContext = JsonComparatorContext.context();
        getUserLoginMethod.validateResponse(comparatorContext);
    }

    @MethodOwner(owner = "sebafermanelli")
    @Test(description = "Update a user that is already registered", priority = 5)
    public void testValidUpdateUser() {
        User user = new User();
        user.setUserName("ThisIsUserName");

        PutUserMethod putUser = new PutUserMethod(user.getUserName());
        putUser.setProperties("api/user/user.properties");
        putUser.expectResponseStatus(HttpResponseStatusType.OK_200);
        putUser.callAPI();

        JsonComparatorContext comparatorContext = JsonComparatorContext.context();
        putUser.validateResponse(comparatorContext);
    }

    @MethodOwner(owner = "lucasp149")
    @Test(description = "Logout an authenticated user", priority = 6)
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

    @MethodOwner(owner = "sebafermanelli")
    @Test(description = "Deletes a user that exist", priority = 7)
    public void testValidDeleteUser() {
        User user = new User();
        user.setUserName("ThisIsUserName");

        DeleteUserMethod deleteUser = new DeleteUserMethod(user.getUserName());
        deleteUser.expectResponseStatus(HttpResponseStatusType.OK_200);
        deleteUser.callAPI();

        JsonComparatorContext comparatorContext = JsonComparatorContext.context();
        deleteUser.validateResponse(comparatorContext);
    }
}

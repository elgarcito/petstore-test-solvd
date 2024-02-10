package com.solvd;

import com.solvd.api.*;
import com.solvd.api.domain.User;
import com.zebrunner.carina.api.apitools.validation.JsonComparatorContext;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.annotations.Test;

public class UserTest extends AbstractTest {

    @Test
    @MethodOwner(owner = "Sebastian F")
    public void test1InvalidDeleteUser() {
        User user = new User();
        user.setUserName("sebafermanelli");

        DeleteUserMethod deleteUser = new DeleteUserMethod(user.getUserName());
        deleteUser.expectResponseStatus(HttpResponseStatusType.NOT_FOUND_404);
        deleteUser.callAPI();
    }

    @Test
    @MethodOwner(owner = "Sebastian F")
    public void test2ValidCreateUser() {
        PostUserMethod postUser = new PostUserMethod();
        postUser.setProperties("api/user/user.properties");

        postUser.expectResponseStatus(HttpResponseStatusType.OK_200);
        postUser.callAPI();

        JsonComparatorContext comparatorContext = JsonComparatorContext.context();
        postUser.validateResponse(comparatorContext);
    }

    @Test
    @MethodOwner(owner = "Sebastian F")
    public void test3ValidGetUserByUsername() {
        User user = new User();
        user.setUserName("sebafermanelli");
        GetUserMethod getUser = new GetUserMethod(user.getUserName());

        getUser.expectResponseStatus(HttpResponseStatusType.OK_200);
        getUser.callAPI();

        JsonComparatorContext comparatorContext = JsonComparatorContext.context();
        getUser.validateResponse(comparatorContext);
    }

//    @Test
//    @MethodOwner(owner = "Sebastian F")
//    public void test4ValidLogin() {
//        User user = new User();
//        user.setUsername("sebafermanelli");
//        user.setPassword("seba123");
//
//        GetLoginUserMethod getLoginUser = new GetLoginUserMethod(user.getUsername(), user.getPassword());
//        getLoginUser.expectResponseStatus(HttpResponseStatusType.OK_200);
//        getLoginUser.callAPI();
//
//        JsonComparatorContext comparatorContext = JsonComparatorContext.context();
//        getLoginUser.validateResponse(comparatorContext);
//    }

    @Test
    @MethodOwner(owner = "Sebastian F")
    public void test5ValidUpdateUser() {
        User user = new User();
        user.setUserName("sebafermanelli");

        PutUserMethod putUser = new PutUserMethod(user.getUserName());
        putUser.setProperties("api/user/user.properties");
        putUser.expectResponseStatus(HttpResponseStatusType.OK_200);
        putUser.callAPI();

        JsonComparatorContext comparatorContext = JsonComparatorContext.context();
        putUser.validateResponse(comparatorContext);
    }

//    @Test
//    @MethodOwner(owner = "Sebastian F")
//    public void test6ValidLogout() {
//        GetLogoutUserMethod getLogoutUser = new GetLogoutUserMethod();
//        getLogoutUser.expectResponseStatus(HttpResponseStatusType.OK_200);
//        getLogoutUser.callAPI();
//
//        JsonComparatorContext comparatorContext = JsonComparatorContext.context();
//        getLogoutUser.validateResponse(comparatorContext);
//    }

    @Test
    @MethodOwner(owner = "Sebastian F")
    public void test7ValidDeleteUser() {
        User user = new User();
        user.setUserName("sebafermanelli");

        DeleteUserMethod deleteUser = new DeleteUserMethod(user.getUserName());
        deleteUser.expectResponseStatus(HttpResponseStatusType.OK_200);
        deleteUser.callAPI();

        JsonComparatorContext comparatorContext = JsonComparatorContext.context();
        deleteUser.validateResponse(comparatorContext);
    }
}

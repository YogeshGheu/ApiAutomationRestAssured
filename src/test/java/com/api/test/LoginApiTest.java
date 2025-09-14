package com.api.test;

import static io.restassured.RestAssured.*;

import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.services.AuthService;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(com.api.listeners.TestListener.class)
public class LoginApiTest {

    @Test(description = "verify if login api is working")
    public void loginTest(){

        LoginRequest loginRequest = new LoginRequest("uday1234", "uday12345");
        AuthService authService = new AuthService();
        SoftAssert softAssert = new SoftAssert();
        Response response = authService.login(loginRequest);

        LoginResponse loginResponse = response.as(LoginResponse.class);
        System.out.println(loginResponse.getUsername());
        System.out.println(loginResponse.getEmail());
        Assert.assertEquals(loginResponse.getId(), 1);

        softAssert.assertEquals(loginResponse.getId(), 1);

        softAssert.assertAll();
    }
}

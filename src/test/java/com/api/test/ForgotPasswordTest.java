package com.api.test;

import com.api.services.AuthService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotPasswordTest {
    @Test
    public void testForgotPassword(){
        AuthService authService = new AuthService();
        Response response = authService.forgotPassword("yogeshkacnsjnz321xcx03@gmail.com");
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}

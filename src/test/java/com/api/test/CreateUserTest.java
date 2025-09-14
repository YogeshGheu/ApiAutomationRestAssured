package com.api.test;

import com.api.models.request.SignupRequest;
import com.api.services.AuthService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateUserTest {
    @Test
    public void testCreateUser(){
        AuthService authService = new AuthService();
        SignupRequest userData = new SignupRequest.Builder()
                .email("yogesh03@gmail.com")
                .firstName("yogesh")
                .lastName("gheu")
                .mobileNumber("1231221432")
                .password("yogesh002")
                .username("yogeshgheu03")
                .build();

        Response response = authService.signup(userData);

        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.asPrettyString(), "User registered successfully!");
    }
}

package com.api.test;

import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;
import com.api.services.AuthService;
import com.api.services.UserProfileManagementService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetProfileTest {

    private String token;

    @Test
    public void testGetProfile(){
        AuthService authService = new AuthService();
        String token = authService.login(new LoginRequest("uday1234", "uday12345")).as(LoginResponse.class).getToken();
        UserProfileManagementService userProfileManagementService = new UserProfileManagementService();

        Response response = userProfileManagementService.getProfile("/profile", token);
//        System.out.println(response.asPrettyString());
//        UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
//        Assert.assertEquals(userProfileResponse.getId(), 1);
//        Assert.assertEquals(userProfileResponse.getUsername(), "uday1234");

    }
}

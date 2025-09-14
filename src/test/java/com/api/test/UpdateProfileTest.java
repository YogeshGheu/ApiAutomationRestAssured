package com.api.test;

import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;
import com.api.services.AuthService;
import com.api.services.UserProfileManagementService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class UpdateProfileTest {

    @Test
    public void testUpdateProfile(){
        Map<String, String> user = new HashMap<>();
        user.put("firstName", "Yogesh");
        user.put("lastName", "Yogesh");
        user.put("email", "ALOK1234@yahoo.com");
        user.put("mobileNumber", "4340607565");


        AuthService authService = new AuthService();
        String token = authService.login(new LoginRequest("uday1234", "uday12345")).as(LoginResponse.class).getToken();
        UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
        Response response = userProfileManagementService.updateProfile(user, "/profile", token);

        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}

package com.api.services;

import com.api.base.BaseService;
import com.api.models.request.LoginRequest;
import com.api.models.request.SignupRequest;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class AuthService extends BaseService {
    private final static String BASE_PATH = "/api/auth";

    public Response login(LoginRequest payload){
        return postRequest(payload, BASE_PATH + "/login");
    }

    public Response signup(SignupRequest payload){
        return postRequest(payload, BASE_PATH + "/signup");
    }

    public Response forgotPassword(String email){
        Map<String, String> payload = new HashMap<>();
        payload.put("email", email);
        return postRequest(payload, BASE_PATH + "/forgot-password");
    }








}

package com.api.services;

import com.api.base.BaseService;
import io.restassured.response.Response;

import java.util.Map;

public class UserProfileManagementService extends BaseService {
    private static final String BASE_PATH = "/api/users";

    public Response getProfile(String endpoint, String token){
        setToken(token);
        return getRequest(BASE_PATH + endpoint);
    }

    public Response updateProfile(Object payload, String endpoint, String token){
        setToken(token);
        return putRequest(payload, BASE_PATH + endpoint);
    }




}

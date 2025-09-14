package com.api.base;

import static io.restassured.RestAssured.*;

import com.api.filters.ApiFilters;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {
    // base uri
    // creating requests
    // handling response
    static {
        RestAssured.filters(new ApiFilters());
    }

    private static final String BASE_URL = "https://swift.techwithjatin.com";

    private RequestSpecification requestSpecification;

    public BaseService() {
        requestSpecification = given().baseUri(BASE_URL);
    }

    protected Response postRequest(Object body, String endpoint) {
        return requestSpecification.contentType(ContentType.JSON).body(body).post(endpoint);
    }

    protected Response getRequest(String endpoint) {
        return requestSpecification.get(endpoint);
    }

    protected void setToken(String token) {
        requestSpecification.header("Authorization", "Bearer " + token);
    }

    protected Response putRequest(Object body, String endpoint){
        return requestSpecification.contentType(ContentType.JSON).body(body).put(endpoint);
    }


}

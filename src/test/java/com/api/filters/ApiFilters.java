package com.api.filters;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ApiFilters implements Filter {

    private final static Logger logger = LogManager.getLogger(ApiFilters.class);

    public Response filter(FilterableRequestSpecification var1, FilterableResponseSpecification var2, FilterContext var3) {
            logRequest(var1);
            Response response = var3.next(var1, var2);
            logResponse(response);
            return response;
    }

    public void logRequest(FilterableRequestSpecification requestSpecification) {
        logger.info("Base URI : {}", requestSpecification.getBaseUri());
        logger.info("Request Header : {}", requestSpecification.getHeaders());
        Object body = requestSpecification.getBody();
        if (body != null) {
            logger.info("Request Payload : {}", body);
        } else {
            logger.info("Request Payload : <empty>");
        }
    }

    public void logResponse(Response response){
        logger.info("Status Code : {}", response.getStatusCode());
        logger.info("Response Headers : {}", response.getHeaders());
        logger.info("Response Body : {}", response.getBody().asString());
    }


}

package com.API_Automation.actions;

import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;

public class AssertActions {

    public void verifyResponseBody(String actual, String expected, String description){
        assertEquals(actual, expected, description);
    }

    public void verifyResponseBody(int actual, int expected, String description){
        assertEquals(actual, expected, description);
    }

    public void verifyResponseBody(float actual, float expected, String description){
        assertEquals(actual, expected, description);
    }

    public void verifyResponseBody(double actual, double expected, String description){
        assertEquals(actual, expected, description);
    }

    public void verifyResponseBody(boolean actual, boolean expected, String description){
        assertEquals(actual, expected, description);
    }

    public void verifyStatusCodeValidResponse(Response response){
        assertEquals(response.getStatusCode(), 200, "It passed");
    }

    public void verifyStatusCodeInvalidResponse(Response response){
        assertEquals(response.getStatusCode(), 500, "It failed");
    }
}

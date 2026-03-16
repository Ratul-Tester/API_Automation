package com.API_Automation.Base;

import com.API_Automation.actions.AssertActions;
import com.API_Automation.endpoints.APIConstants;
import com.API_Automation.modules.PayloadManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public RequestSpecification requestSpecification;
    public Response  response;
    public ValidatableResponse validatableResponse;
    public AssertActions assertActions;
    public APIConstants apiConstants;
    public PayloadManager payloadManager;
    public JsonPath jsonPath;

    @BeforeTest
    public void setConfiguration(){
        System.out.println("Setting up configuration");
        System.out.println("Before Test");

        payloadManager = new PayloadManager();
        assertActions = new AssertActions();
        requestSpecification = new RequestSpecBuilder().setBaseUri(APIConstants.Base_URL)
    }

    public String getToken(){
        System.out.println("Getting token");
        return null;
    }

}

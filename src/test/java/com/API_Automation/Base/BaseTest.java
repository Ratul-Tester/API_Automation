package com.API_Automation.Base;

import com.API_Automation.actions.AssertActions;
import com.API_Automation.endpoints.APIConstants;
import com.API_Automation.modules.PayloadManager;
import com.API_Automation.pojofiles.Auth;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.http.auth.AUTH;
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
                .addHeader("Content-Type","application/json")
                .build().log().all();
    }

    public String getToken(){
        //message
        System.out.println("Getting token");

        //Setting up the Urls
        requestSpecification = RestAssured.given()
                .baseUri(APIConstants.Base_URL)
                .basePath(APIConstants.Auth_Path);

        //Setting up the Payload
        String payload = payloadManager.createAuthPayload();

        //Getting the Response
               response = requestSpecification
                .contentType(ContentType.JSON)
                .body(payload)
                .when().post();

        //Extracting of the Token via Deserialization
        String token = payloadManager.getTokenfromJson(response.asString());

        //Verify
        return token;
    }


}

package com.API_Automation.testcases.CRUD.Sample;

import com.API_Automation.Base.BaseTest;
import com.API_Automation.endpoints.APIConstants;
import com.API_Automation.pojofiles.BookingResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class testCreateBookingSample extends BaseTest {

    @Test(groups = "smoke")
    @Owner("Ratul")
    @Severity(SeverityLevel.NORMAL)
    @Description("TC#1 - Verify the new booking")
    public void createBooking(){

        requestSpecification.basePath(APIConstants.Create_Booking_Path);
        response = RestAssured
                .given(requestSpecification).body(payloadManager.createBookingPayloadMethodPost())
                .when().post();
                /*.then().log().all().extract().response();*/

        // Validatable Assertion
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        // Deserialization - Response
        BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());

        //AssertJ
        assertThat(bookingResponse).isNotNull();
        assertThat(bookingResponse.getBookingid()).isNotNull();
        assertThat(bookingResponse.getBookingid()).isNotEqualTo(0);
        assertThat(bookingResponse.getBooking().getFirstname()).isNotNull();
        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("Ramesh");

        //TestNG Assertions
        assertActions.verifyStatusCodeValidResponse(response);
    }

    @Test(groups = "smoke")
    @Owner("Ratul")
    @Severity(SeverityLevel.NORMAL)
    @Description("TC#2 - Verify the new Invalid booking")
    public void createInvalidBooking(){

        requestSpecification.basePath(APIConstants.Create_Booking_Path);
        response = RestAssured
                .given(requestSpecification).body(payloadManager.createWithEmptyBookingPayloadMethodPost())
                .when().post();
        /*.then().log().all().extract().response();*/

        // Validatable Assertion
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(500);

        // Deserialization - Response
        /*BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());*/

        //AssertJ
        /*assertThat(bookingResponse).isNull();
        assertThat(bookingResponse.getBookingid()).isNull();*/

        //TestNG Assertions
        assertActions.verifyStatusCodeInvalidResponse(response);
    }
}

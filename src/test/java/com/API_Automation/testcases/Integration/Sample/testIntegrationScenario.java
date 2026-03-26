package com.API_Automation.testcases.Integration.Sample;

import com.API_Automation.Base.BaseTest;
import com.API_Automation.endpoints.APIConstants;
import com.API_Automation.pojofiles.Booking;
import com.API_Automation.pojofiles.BookingResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class testIntegrationScenario extends BaseTest {

    //Create a Booking, Create a Token
    //Get booking
    //update the booking
    //Delete the booking


    @Description("TC#INT-1 - Step1, Create a Booking")
    @Owner("Ratul")
    @Test(groups = "integration", priority = 1)
    public void testCreateBooking(ITestContext iTestContext){
        iTestContext.setAttribute("token", getToken());
        requestSpecification.basePath(APIConstants.Booking_Path);
        response = RestAssured
                .given(requestSpecification).body(payloadManager.createBookingPayloadMethodPost())
                .when().post();


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

        //Set the bookingid for further use
        iTestContext.setAttribute("bookingid", bookingResponse.getBookingid());
    }

    @Description("TC#INT-2 - Step2, Verify the Booking")
    @Owner("Ratul")
    @Test(groups = "integration", priority = 2)
    public void testVerifyBooking(ITestContext iTestContext){

        String bookingid = iTestContext.getAttribute("bookingid").toString();

        String basePathGetBooking = APIConstants.Booking_Path+"/"+bookingid;

        requestSpecification.basePath(basePathGetBooking);
        response = RestAssured
                .given(requestSpecification)
                .when().get();

        // Validatable Assertion
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        Booking booking = payloadManager.getResponsefromJson(response.asString());

        assertThat(booking).isNotNull();
        assertThat(booking).isNotEqualTo(0);
        assertThat(booking.getFirstname()).isNotNull();
        assertThat(booking.getFirstname()).isEqualTo("Ramesh");

    }

    @Description("TC#INT-3 - Step3, Update the Booking")
    @Owner("Ratul")
    @Test(groups = "integration", priority = 3)
    public void testUpdateBooking(ITestContext iTestContext){

        String token = iTestContext.getAttribute("token").toString();
        String bookingid = iTestContext.getAttribute("bookingid").toString();

        String basePathGetBooking = APIConstants.Booking_Path+"/"+bookingid;

        requestSpecification.basePath(basePathGetBooking);
        response = RestAssured
                .given(requestSpecification)
                .cookie("token", token)
                .when().body(payloadManager.updateBookingPayloadMethodPut()).put();

        // Validatable Assertion
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        Booking booking = payloadManager.getResponsefromJson(response.asString());

        assertThat(booking).isNotNull();
        assertThat(booking).isNotEqualTo(0);
        assertThat(booking.getFirstname()).isNotNull();
        assertThat(booking.getFirstname()).isEqualTo("Ganesh");

    }

    @Description("TC#INT-4 - Step4, Delete the Booking")
    @Owner("Ratul")
    @Test(groups = "integration", priority = 4)
    public void testDeleteBooking(ITestContext iTestContext){
        String token = iTestContext.getAttribute("token").toString();
        String bookingid = iTestContext.getAttribute("bookingid").toString();

        String basePathGetBooking = APIConstants.Booking_Path+"/"+bookingid;

        requestSpecification.basePath(basePathGetBooking);
        response = RestAssured
                .given(requestSpecification)
                .cookie("token", token)
                .when().delete();

        // Validatable Assertion
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(201);

    }
}

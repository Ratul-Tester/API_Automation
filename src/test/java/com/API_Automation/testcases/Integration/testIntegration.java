package com.API_Automation.testcases.Integration;

import com.API_Automation.Base.BaseTest;
import com.API_Automation.actions.AssertActions;
import com.API_Automation.endpoints.APIConstants;
import com.API_Automation.pojofiles.Booking;
import com.API_Automation.pojofiles.BookingResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class testIntegration extends BaseTest {

    //Create a Booking, Create a Token
    //Get booking
    //update the booking
    //Delete the booking

    @Description("Integration TC#1 - Create a Booking and verify firstname")
    @Owner("Ratul Nandy")
    @Test(groups = "Integration", priority = 1)
    public void createBooking(ITestContext iTestContext) {
        iTestContext.setAttribute("token", getToken());

        requestSpecification.basePath(APIConstants.Booking_Path);
        response = RestAssured.given().spec(requestSpecification)
                .when().body(payloadManager.createBookingPayloadMethodPost()).post();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());
        assertThat(bookingResponse.getBookingid()).isNotNull().isNotZero().isNotNegative();
        assertThat(bookingResponse.getBooking().getFirstname()).isNotBlank();
        assertThat(bookingResponse.getBooking().getFirstname()).isEqualToIgnoringCase("ramesh");

        iTestContext.setAttribute("bookingid", bookingResponse.getBookingid());

    }

    @Description("Integration TC#2 - Get the Booking by ID")
    @Owner("Ratul Nandy")
    @Test(groups = "Integration", priority = 2)
    public void getBooking(ITestContext iTestContext) {;
        System.out.println("bookingid for get booking : " + iTestContext.getAttribute("bookingid"));
        String bookingid = iTestContext.getAttribute("bookingid").toString();
        String basePathGet =  APIConstants.Booking_Path+"/"+bookingid;

        //String getBookingIdUrl = APIConstants.Booking_Path+"/"+bookingid;

        requestSpecification.basePath(basePathGet);
        response = RestAssured.given().spec(requestSpecification).when().get();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        BookingResponse bookingResponse1 = payloadManager.bookingResponseJava(response.asString());
        assertThat(bookingResponse1.getBooking().getLastname()).isEqualTo("Nandy");
    }

    @Description("Integration TC#3 - Update the Booking and verify firstname")
    @Owner("Ratul Nandy")
    @Test(groups = "Integration", priority = 3)
    public void updateBooking(ITestContext iTestContext) {
        System.out.println("token for Update booking : " + iTestContext.getAttribute("token"));
        String token = iTestContext.getAttribute("token").toString();

        System.out.println("bookingid for get booking : " + iTestContext.getAttribute("bookingid"));
        String bookingid = iTestContext.getAttribute("bookingid").toString();

        String getBookingIdUrl = APIConstants.Booking_Path+"/"+ bookingid;

        requestSpecification.basePath(getBookingIdUrl);
        response = RestAssured.given().spec(requestSpecification)
                .cookie("token", token)
                .when().body(payloadManager.updateBookingPayloadMethodPut()).put();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

//        BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());
//        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("Ganesh");
//        assertThat(bookingResponse.getBooking().getLastname()).isEqualTo("Roy");
    }

    @Description("Integration TC#4 - Delete the Booking")
    @Owner("Ratul Nandy")
    @Test(groups = "Integration", priority = 4)
    public void deleteBooking(ITestContext iTestContext) {
        System.out.println("token for Update booking : " + iTestContext.getAttribute("token"));
        String token = iTestContext.getAttribute("token").toString();

        System.out.println("bookingid for get booking : " + iTestContext.getAttribute("bookingid"));
        String bookingid = iTestContext.getAttribute("bookingid").toString();

        String getBookingIdUrl = APIConstants.Booking_Path+"/"+bookingid;

        requestSpecification.basePath(getBookingIdUrl);
        response = RestAssured.given().spec(requestSpecification)
                .cookie("token", token)
                .when().delete();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(201);
    }

}

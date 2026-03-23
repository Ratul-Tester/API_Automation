package com.API_Automation.testcases.Integration;

import com.API_Automation.Base.BaseTest;
import com.API_Automation.endpoints.APIConstants;
import com.API_Automation.pojofiles.BookingResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class testIntegration extends BaseTest {

    //Create a Booking, Create a Token
    //Get booking
    //update the booking
    //Delete the booking


    @Description("TC#INT-1 - Step1, Create a Booking")
    @Owner("Ratul")
    @Test(groups = "integration", priority = 1)
    public void testCreateBooking(ITestContext itestcontext){
        itestcontext.setAttribute("token", getToken());

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

        //Set the booking Id
        itestcontext.setAttribute("bookingid", bookingResponse.getBookingid());

    }

    @Description("TC#INT-2 - Step2, Verify the Booking")
    @Owner("Ratul")
    @Test(groups = "integration", priority = 2)
    public void testVerifyBooking(ITestContext itestcontext){
        String bookingid = itestcontext.getAttribute("bookingid").toString();

        String basePathGet = APIConstants.Base_URL+"/"+bookingid;
        requestSpecification.basePath(basePathGet);
        response = RestAssured
                .given(requestSpecification)
                .when().get();
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

    @Description("TC#INT-3 - Step3, Update the Booking")
    @Owner("Ratul")
    @Test(groups = "integration", priority = 3)
    public void testUpdateBooking(ITestContext itestcontext){
        System.out.println("Token is - "+itestcontext.getAttribute("token"));
        Assert.assertTrue(true);

    }

    @Description("TC#INT-4 - Step4, Delete the Booking")
    @Owner("Ratul")
    @Test(groups = "integration", priority = 4)
    public void testDeleteBooking(ITestContext itestcontext){
        System.out.println("Token is - "+itestcontext.getAttribute("token"));
        Assert.assertTrue(true);

    }
}

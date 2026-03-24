package com.API_Automation.testcases.CRUD;

import com.API_Automation.Base.BaseTest;
import com.API_Automation.actions.AssertActions;
import com.API_Automation.endpoints.APIConstants;
import com.API_Automation.modules.PayloadManager;
import com.API_Automation.pojofiles.BookingResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class testCreateBooking extends BaseTest {

    @Test(groups = "smoke")
    @Owner("Ratul")
    @Severity(SeverityLevel.NORMAL)
    @Description("TC#1 - Verify that booking is created")
    public void createBooking(){
        requestSpecification.basePath(APIConstants.Create_Booking_Path);
        response = requestSpecification.when().body(payloadManager.CreateBookingPayloadPostMethod()).post();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());

        assertThat(bookingResponse.getBookingid()).isNotNull();
        assertThat(bookingResponse.getBooking().getFirstname()).isNotNull().isEqualTo("Ram");

        assertActions.verifyStatusCodeValidResponse(response);

    }
}

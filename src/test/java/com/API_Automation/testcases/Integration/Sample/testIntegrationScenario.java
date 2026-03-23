package com.API_Automation.testcases.Integration.Sample;

import com.API_Automation.Base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testIntegrationScenario extends BaseTest {

    //Create a Booking, Create a Token
    //Get booking
    //update the booking
    //Delete the booking


    @Description("TC#INT-1 - Step1, Create a Booking")
    @Owner("Ratul")
    @Test(groups = "integration", priority = 1)
    public void testCreateBooking(){
        Assert.assertTrue(true);

    }

    @Description("TC#INT-2 - Step2, Verify the Booking")
    @Owner("Ratul")
    @Test(groups = "integration", priority = 2)
    public void testVerifyBooking(){
        Assert.assertTrue(true);

    }

    @Description("TC#INT-3 - Step3, Update the Booking")
    @Owner("Ratul")
    @Test(groups = "integration", priority = 3)
    public void testUpdateBooking(){
        Assert.assertTrue(true);

    }

    @Description("TC#INT-4 - Step4, Delete the Booking")
    @Owner("Ratul")
    @Test(groups = "integration", priority = 4)
    public void testDeleteBooking(){
        Assert.assertTrue(true);

    }
}

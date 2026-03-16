package com.API_Automation.modules;

import com.API_Automation.pojofiles.Auth;
import com.API_Automation.pojofiles.Booking;
import com.API_Automation.pojofiles.Bookingdates;
import com.google.gson.Gson;

public class PayloadManager {

    Gson gson;

    public String CreateBookingPayloadPostMethod(){

        Booking booking = new Booking();
        booking.setFirstname("Ram");
        booking.setLastname("Chandra");
        booking.setTotalprice(121);
        booking.setDepositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2020-01-12");
        bookingdates.setCheckout("2021-01-12");

        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");
        return gson.toJson(booking);
    }

    public String UpdateBookingPayloadPutMethod(){

        Booking booking = new Booking();
        booking.setFirstname("Laxman");
        booking.setLastname("Chandra");
        booking.setTotalprice(120);
        booking.setDepositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2020-01-12");
        bookingdates.setCheckout("2021-01-12");

        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast and Lunch");
        return gson.toJson(booking);
    }

    public String PartialUpdateBookingPayloadPatchMethod(){

        Booking booking = new Booking();
        booking.setFirstname("Sita");
        booking.setLastname("Ram");
        booking.setTotalprice(1);
        booking.setDepositpaid(false);

        return gson.toJson(booking);
    }

    public String AuthPayloadPostMethod(){
        Auth auth = new Auth();
        auth.setUsername("admin");
        auth.setPassword("password123");
        return gson.toJson(auth);
    }
}

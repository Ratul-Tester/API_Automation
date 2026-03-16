package com.API_Automation.modules;

import com.API_Automation.pojofiles.Auth;
import com.API_Automation.pojofiles.Booking;
import com.API_Automation.pojofiles.Bookingdates;
import com.google.gson.Gson;

public class PayloadManager {

    Gson gson = new Gson();

    public String createBookingPayloadMethodPost(){

        Booking booking = new Booking();
        booking.setFirstname("Ramesh");
        booking.setLastname("Nandy");
        booking.setTotalprice(124);
        booking.setDepositpaid(false);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2018-04-20");
        bookingdates.setCheckout("2019-04-20");

        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        return gson.toJson(booking);
    }

    public String updateBookingPayloadMethodPut(){

        Booking booking = new Booking();
        booking.setFirstname("Ganesh");
        booking.setLastname("Roy");
        booking.setTotalprice(143);
        booking.setDepositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2019-04-20");
        bookingdates.setCheckout("2020-04-20");

        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast+Lunch");

        return gson.toJson(booking);
    }

    public String partialBookingPayloadMethodPatch(){

        Booking booking = new Booking();
        booking.setFirstname("Sambh");
        booking.setLastname("Sadashiv");
        booking.setTotalprice(8);

        return gson.toJson(booking);
    }

    public String createAuthPayload(){

        Auth  auth = new Auth();
        auth.setUsername("admin");
        auth.setPassword("password123");
        return gson.toJson(auth);
    }
}

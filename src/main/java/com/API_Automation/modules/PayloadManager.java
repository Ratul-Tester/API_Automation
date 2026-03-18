package com.API_Automation.modules;

import com.API_Automation.pojofiles.Auth;
import com.API_Automation.pojofiles.Booking;
import com.API_Automation.pojofiles.BookingResponse;
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

        gson = new Gson();

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

        gson = new Gson();
        return gson.toJson(booking);
    }

    public String PartialUpdateBookingPayloadPatchMethod() {

        Booking booking = new Booking();
        booking.setFirstname("Sita");
        booking.setLastname("Ram");
        booking.setTotalprice(1);
        booking.setDepositpaid(false);

        gson = new Gson();
        return gson.toJson(booking);
    }

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

        gson = new Gson();
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

        gson = new Gson();
        return gson.toJson(booking);
    }

    public String partialBookingPayloadMethodPatch(){

        Booking booking = new Booking();
        booking.setFirstname("Sambh");
        booking.setLastname("Sadashiv");
        booking.setTotalprice(8);

        gson = new Gson();
        return gson.toJson(booking);
    }


    /*public String AuthPayloadPostMethod(){
        Auth auth = new Auth();*/

    public String createAuthPayload(){

        Auth  auth = new Auth();

        auth.setUsername("admin");
        auth.setPassword("password123");
        gson = new Gson();
        return gson.toJson(auth);
    }

    public BookingResponse bookingResponseJava(String responseString){

        gson = new Gson();
        BookingResponse bookingResponse = gson.fromJson(responseString, BookingResponse.class);
        return bookingResponse;
    }
}

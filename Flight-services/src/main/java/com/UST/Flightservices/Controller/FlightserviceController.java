package com.UST.Flightservices.Controller;

import com.UST.Flightservices.Dto.BookingRequest;
import com.UST.Flightservices.Dto.FlightBookingAcknowledgement;
import com.UST.Flightservices.Exception.InsufficientAmountException;
import com.UST.Flightservices.Services.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightserviceController {
    @Autowired
    private FlightBookingService fltbkngsrvs;
    @PostMapping("/booking")
    public FlightBookingAcknowledgement bookingFlightTicket(@RequestBody BookingRequest request) throws InsufficientAmountException {
        return fltbkngsrvs.bookingFlightTicket(request);
    }


}

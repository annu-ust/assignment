package com.UST.Flightservices.Services;

import com.UST.Flightservices.Dto.BookingRequest;
import com.UST.Flightservices.Dto.FlightBookingAcknowledgement;
import com.UST.Flightservices.Entity.Passengerinfo;
import com.UST.Flightservices.Entity.PaymentInfo;
import com.UST.Flightservices.Exception.InsufficientAmountException;
import com.UST.Flightservices.Repo.Passengerrepo;
import com.UST.Flightservices.Repo.Paymentrepo;
import com.UST.Flightservices.Util.PaymentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class FlightBookingService {

    @Autowired
    private Paymentrepo paymentrepo;
    @Autowired
    private Passengerrepo passengerrepo;
    @Transactional

    public FlightBookingAcknowledgement bookingFlightTicket(BookingRequest request) throws InsufficientAmountException {
        Passengerinfo passangerinfo =request.getPassengerinfo();
        passangerinfo=passengerrepo.save(passangerinfo);
        PaymentInfo paymentinfo=request.getPaymentInfo();
        PaymentUtils.validateCreditLimit(paymentinfo.getAccountNo(),passangerinfo.getFare());
        paymentinfo.setPassengerId(passangerinfo.getPid());
        paymentinfo.setAmount(passangerinfo.getFare());
        paymentrepo.save(paymentinfo);
        return new FlightBookingAcknowledgement("success",passangerinfo.getFare(),
                UUID.randomUUID().toString().split("-")[0],passangerinfo);
    }
}

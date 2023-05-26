package com.UST.Flightservices.Dto;

import com.UST.Flightservices.Entity.Passengerinfo;
import com.UST.Flightservices.Entity.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookingRequest {
    private Passengerinfo passengerinfo;
    private PaymentInfo paymentInfo;
}

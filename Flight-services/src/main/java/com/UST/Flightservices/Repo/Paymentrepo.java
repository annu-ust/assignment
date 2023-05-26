package com.UST.Flightservices.Repo;

import com.UST.Flightservices.Entity.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Paymentrepo extends JpaRepository<PaymentInfo,String> {
}

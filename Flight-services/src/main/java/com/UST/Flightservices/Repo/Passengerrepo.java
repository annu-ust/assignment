package com.UST.Flightservices.Repo;

import com.UST.Flightservices.Entity.Passengerinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Passengerrepo extends JpaRepository<Passengerinfo,Long> {
}

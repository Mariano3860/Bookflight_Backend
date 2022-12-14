package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.BookFlight;
import net.javaguides.springboot.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long>{

}

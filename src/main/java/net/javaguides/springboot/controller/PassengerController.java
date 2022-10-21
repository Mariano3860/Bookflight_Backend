package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.BookFlight;
import net.javaguides.springboot.model.Passenger;
import net.javaguides.springboot.repository.BookFlightRepository;
import net.javaguides.springboot.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/Passenger/")
public class PassengerController {

	@Autowired
	private PassengerRepository PassengerRepository;

	@PostMapping("addPassenger")
	public Passenger createPassenger(Passenger passenger){
		return PassengerRepository.save(passenger);
	}		

}

package net.javaguides.springboot.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.javaguides.springboot.model.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import net.javaguides.springboot.model.BookFlight;
import net.javaguides.springboot.repository.BookFlightRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/BookFlight/")
public class BookFlightController {

	@Autowired
	private BookFlightRepository bookFlightRepository;

	@PostMapping("addBook")
	public BookFlight createBookFlight(@RequestBody BookFlight bookFlight){
		return bookFlightRepository.save(bookFlight);
	}

	@GetMapping("dates")
	public ArrayList<LocalDate> createBookFlight(){
		ArrayList<LocalDate> dates = new ArrayList<LocalDate>();
		dates.add(LocalDate.now().plusDays(1));
		dates.add(LocalDate.now().plusDays(2));
		dates.add(LocalDate.now().plusDays(3));
		dates.add(LocalDate.now().plusDays(7));
		dates.add(LocalDate.now().plusDays(8));
		dates.add(LocalDate.now().plusDays(15));
		dates.add(LocalDate.now().plusDays(30));
		dates.add(LocalDate.now().plusDays(38));
		dates.add(LocalDate.now().plusDays(52));
		return dates;
	}

	@PostMapping("price")
	public double returnDate(@RequestBody BookFlight bookFlight) {

		double price = 0;
		if (bookFlight!= null){
			//Precio por pasajero adulto
			int passengersA =  bookFlightRepository.getAdultByBookId(bookFlight.getId()).size();
			price += 1000*passengersA;

			//Precio por pasajero joven
			int passengersC =  bookFlightRepository.getChildByBookId(bookFlight.getId()).size();
			price += 500*passengersC;

			//Precio por maleta
			ArrayList<Passenger> passLug = (ArrayList<Passenger>) bookFlightRepository.getPassengersLuggageByBookId(bookFlight.getId());
			Integer numMaletas = 0;
			for( Passenger p : passLug){
				numMaletas += p.getLuggage();
			}
			price += 50*numMaletas;

			//Precio por roundtrip
			if (bookFlight.getRoundTrip()){
				price = price * 1.8;
			}

			//Precio por destination
			switch (bookFlight.getDestino().toLowerCase()){
				case "tokyo":
					price= price * 3.8;
					break;
				case "roma":
					price= price * 2.3;
					break;
				case "madrid":
					price= price * 1.5;
					break;
			}

		}
		return price;
	}

}


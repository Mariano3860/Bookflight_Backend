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
@RequestMapping("/api/BookFlight")
public class BookFlightController {

	@Autowired
	private BookFlightRepository BookFlightRepository;
	
	// get all employees
	@PostMapping("/addBook")
	public BookFlight createBookFlight(@RequestBody BookFlight bookFlight){
		return BookFlightRepository.save(bookFlight);
	}

	@GetMapping("/dates")
	public ArrayList<LocalDate> createBookFlight(){
		ArrayList<LocalDate> dates = new ArrayList<LocalDate>();
		dates.add(LocalDate.now().plusDays(1));
		dates.add(LocalDate.now().plusDays(3));
		dates.add(LocalDate.now().plusDays(8));
		dates.add(LocalDate.now().plusDays(15));
		dates.add(LocalDate.now().plusDays(30));
		dates.add(LocalDate.now().plusDays(38));
		dates.add(LocalDate.now().plusDays(52));
		return dates;
	}

	@PostMapping("/price")
	public double returnDate(@RequestBody BookFlight bookFlight) {

		//Chequear los pasageros con el book id enviado, chequear edad, devolver el numero
		//Numero pasajeros = Precio + 1000 * num pasajeros
		//Chequear lagaje de los pasajero y devolver numero de valijas
		//Numero de valijas => precio+50*Valijas
		//RoundTrip = true => Precio*1.8
		//Destination => Si es 1 => Precio*1.2 , si es 2....

		double price = 0;
		if (bookFlight!= null){
			//Precio por pasajero adulto
			int passengersA =  BookFlightRepository.getAdultByBookId(bookFlight.getId()).size();
			price += 1000*passengersA;

			//Precio por pasajero joven
			int passengersC =  BookFlightRepository.getChildByBookId(bookFlight.getId()).size();
			price += 500*passengersC;

			//Precio por maleta
			ArrayList<Passenger> passLug = (ArrayList<Passenger>) BookFlightRepository.getPassengersLuggageByBookId(bookFlight.getId());
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

//	// get employee by id rest api
//	@GetMapping("/employees/{id}")
//	public ResponseEntity<BookFlight> getEmployeeById(@PathVariable Long id) {
//		BookFlight employee = employeeRepository.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
//		return ResponseEntity.ok(employee);
//	}
//
//	// update employee rest api
//
//	@PutMapping("/employees/{id}")
//	public ResponseEntity<BookFlight> updateEmployee(@PathVariable Long id, @RequestBody BookFlight employeeDetails){
//		BookFlight employee = employeeRepository.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
//
//		employee.setFirstName(employeeDetails.getFirstName());
//		employee.setLastName(employeeDetails.getLastName());
//		employee.setEmailId(employeeDetails.getEmailId());
//
//		BookFlight updatedEmployee = employeeRepository.save(employee);
//		return ResponseEntity.ok(updatedEmployee);
//	}
//
//	// delete employee rest api
//	@DeleteMapping("/employees/{id}")
//	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
//		BookFlight employee = employeeRepository.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
//
//		employeeRepository.delete(employee);
//		Map<String, Boolean> response = new HashMap<>();
//		response.put("deleted", Boolean.TRUE);
//		return ResponseEntity.ok(response);
//	}
//
	


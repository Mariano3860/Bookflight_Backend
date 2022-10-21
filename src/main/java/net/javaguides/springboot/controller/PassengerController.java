package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.BookFlight;
import net.javaguides.springboot.model.Passenger;
import net.javaguides.springboot.repository.BookFlightRepository;
import net.javaguides.springboot.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/Passenger")
public class PassengerController {

	@Autowired
	private PassengerRepository PassengerRepository;

	// get all employees
	@PostMapping("/addPassenger")
	public Passenger createPassenger(@RequestBody Passenger passenger){
		return PassengerRepository.save(passenger);
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
	
}
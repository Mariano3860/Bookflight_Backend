package net.javaguides.springboot;

import net.javaguides.springboot.model.BookFlight;
import net.javaguides.springboot.model.Passenger;
import net.javaguides.springboot.repository.BookFlightRepository;
import net.javaguides.springboot.repository.PassengerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;

@DataJpaTest
class RepositoryTest {

    @Autowired
    private PassengerRepository passengerRepository;

    @Test
    void save_PersistANewPassengerWithProperties() {
        Passenger P = new Passenger( 1, "Mariano", "Rojo", "Arg", "adult", 1, 1);
        Passenger P2 = passengerRepository.save(P);
        Assertions.assertNotNull(P2);
        Assertions.assertNotNull(P2.getFirstName());
        Assertions.assertEquals(P.getFirstName(),P2.getFirstName());
    }

}

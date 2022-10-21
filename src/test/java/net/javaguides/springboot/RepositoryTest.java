package net.javaguides.springboot;

import net.javaguides.springboot.model.BookFlight;
import net.javaguides.springboot.repository.BookFlightRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;

@DataJpaTest
class RepositoryTest {

    @Autowired
    private BookFlightRepository bookFlightRepository;


//    @Test
//    void save_PersistANewEmployeeWithProperties() {
//        BookFlight E = new BookFlight("Mariano","Rojo","asd@asd.com");
//        BookFlight E2 = bookFlightRepository.save(E);
//        Assertions.assertNotNull(E2);
//        Assertions.assertNotNull(E2.getId());
//        Assertions.assertEquals(E.getFirstName(),E2.getFirstName());
//        //Assertions.assertEquals(E.getEmailId(),E2.getEmailId());
//    }

    @Test
    void save_ThrowsDataIntegrityExceptionWhenEmailIsNull() {
        BookFlight E = new BookFlight();
        Assertions.assertThrows(DataIntegrityViolationException.class,() -> bookFlightRepository.save(E));
    }

}

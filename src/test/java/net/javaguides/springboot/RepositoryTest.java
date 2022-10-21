package net.javaguides.springboot;

import net.javaguides.springboot.model.BookFlight;
import net.javaguides.springboot.repository.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;

@DataJpaTest
class RepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Test
    void save_PersistANewEmployeeWithProperties() {
        BookFlight E = new BookFlight("Mariano","Rojo","asd@asd.com");
        BookFlight E2 = employeeRepository.save(E);
        Assertions.assertNotNull(E2);
        Assertions.assertNotNull(E2.getId());
        Assertions.assertEquals(E.getFirstName(),E2.getFirstName());
        //Assertions.assertEquals(E.getEmailId(),E2.getEmailId());
    }

    @Test
    void save_ThrowsDataIntegrityExceptionWhenEmailIsNull() {
        BookFlight E = new BookFlight();
        Assertions.assertThrows(DataIntegrityViolationException.class,() -> employeeRepository.save(E));
    }

}

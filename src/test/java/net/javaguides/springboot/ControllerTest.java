package net.javaguides.springboot;

import net.javaguides.springboot.model.BookFlight;
import net.javaguides.springboot.model.Passenger;
import net.javaguides.springboot.repository.BookFlightRepository;
import net.javaguides.springboot.repository.PassengerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

    @Mock
    private PassengerRepository passengerRepository;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void initRepo(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void test() throws Exception {
        given(passengerRepository.save(any(Passenger.class)))
                .willReturn(new Passenger( 1, "Mariano", "Rojo", "Arg", "adult", 1, 1));

        mockMvc.perform(post("/api/Passenger/addPassenger").content("{\n" +
                "    \"id\": \"1\",\n" +
                "    \"firstName\": \"aa\",\n" +
                "    \"lastName\": \"aa\",\n" +
                "    \"nationality\": \"aa\",\n" +
                "    \"age\": \"adult\",\n" +
                "    \"luggage\": \"1\",\n" +
                "    \"bookId\": \"1\",\n" +
                "}").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.firstName").value("aa"))
                .andDo(print());
    }

}

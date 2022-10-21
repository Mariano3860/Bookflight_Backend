package net.javaguides.springboot;

import net.javaguides.springboot.model.BookFlight;
import net.javaguides.springboot.repository.EmployeeRepository;
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
    private EmployeeRepository employeeRepository;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void initRepo(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void test() throws Exception {
        given(employeeRepository.save(any(BookFlight.class)))
                .willReturn(new BookFlight("Mariano","Rojo","asd@asd.com"));

        mockMvc.perform(post("/api/v1/employees").content("{\n" +
                "    \"firstName\": \"aa\",\n" +
                "    \"lastName\": \"aa\",\n" +
                "    \"emailId\": \"\"\n" +
                "}").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.firstName").value("aa"))
                .andDo(print());
    }



}

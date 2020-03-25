package edu.eci.arsw.covidcases;


import edu.eci.arsw.covidcases.controllers.CovidCasesAPIController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CovidCasesAPIController.class)
public class ParcialAPIControllerTests {
/**
    @Autowired
    private MockMvc mvc;

    @Test
    public void shouldGetAirportsByName() throws Exception {
        mvc.perform(get("/airports/berlin")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted());
    }

    @Test
    public void shouldNotGetAirportsByNameIfDoesntExist() throws Exception {
        mvc.perform(get("/airports/ciudadgotica")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
**/
}
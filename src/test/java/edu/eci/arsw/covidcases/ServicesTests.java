package edu.eci.arsw.covidcases;

import edu.eci.arsw.covidcases.Exceptions.CovidCasesException;
import edu.eci.arsw.covidcases.services.CovidCasesServices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServicesTests {
/**
    @Autowired
    CovidCasesServices covidCasesServices;

    @Test
    public void shouldGetAirportsByName() throws CovidCasesException {
        String response = covidCasesServices.getAirportsByName("berlin");
        assertNotNull(response);
        assertTrue(response.contains("Berlin"));
    }

    @Test
    public void shouldNotGetAirportsByNameIfDoesntExist(){
        try {
            String response = covidCasesServices.getAirportsByName("ciudadgotica");
            fail("No debería existir este aeropuerto");
        } catch (CovidCasesException e) {
            assertEquals("Not Found",e.getMessage());
        }
    }
    **/
}
package edu.eci.arsw.covidcases;
import edu.eci.arsw.covidcases.Exceptions.CovidCasesException;
import edu.eci.arsw.covidcases.HttpConection.HttpConectionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HttpConectorTests {
/**
    @Autowired
    private HttpConectionService httpConectionService;

    @Test
    public void shouldGetAirportsByName() throws CovidCasesException {
        String response = httpConectionService.getStatisticsByCountry("berlin");
        assertNotNull(response);
        System.out.println(response);
        assertTrue(response.contains("Berlin"));
    }

    @Test
    public void shouldNotGetAirportsByNameIfDoesntExist()  {
        try {
            String response = httpConectionService.getStatisticsByCountry("ciudadgotica");
            System.out.println(response);

            fail("No debería existir este aeropuerto");
        } catch (CovidCasesException e) {
            assertEquals("Not Found",e.getMessage());
        }
    }
**/
}
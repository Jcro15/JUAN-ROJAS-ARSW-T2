package edu.eci.arsw.covidcases;
import edu.eci.arsw.covidcases.Exceptions.CovidCasesException;
import edu.eci.arsw.covidcases.HttpConection.HttpConectionService;
import edu.eci.arsw.covidcases.model.Country;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HttpConectorTests {

    @Autowired
    private HttpConectionService httpConectionService;

    @Test
    public void shouldGetStatisticsByCountry() throws CovidCasesException {
        Country c = httpConectionService.getStatisticsByCountry("Canada");
        assertNotNull(c);
        assertTrue(c.getCountryname().equals("Canada"));
    }

    @Test
    public void shouldNotGetStatisticsByCountry()  {
        try {
            Country c = httpConectionService.getStatisticsByCountry("ciudad 1");
            fail("Esta ciudad no esta en la api");
        } catch (CovidCasesException e) {
            assertEquals("El pais no fue encontrado",e.getMessage());
        }
    }
    @Test
    public void shouldGetStatistics(){
        try {
            HashMap<String,Country> r= httpConectionService.getStatistics();
            assertNotNull(r);
            assertTrue(r.containsKey("Canada"));
        } catch (CovidCasesException e) {
            e.printStackTrace();
        }
    }

}
package edu.eci.arsw.covidcases;

import edu.eci.arsw.covidcases.Exceptions.CovidCasesException;
import edu.eci.arsw.covidcases.model.Country;
import edu.eci.arsw.covidcases.services.CovidCasesServices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServicesTests {

    @Autowired
    CovidCasesServices covidCasesServices;

    @Test
    public void shouldGetStatisticsByCountry() throws CovidCasesException {
        Country c = covidCasesServices.getStatisticsByCountry("Canada");
        assertNotNull(c);
        assertTrue(c.getCountryname().equals("Canada"));
    }

    @Test
    public void shouldNotGetStatisticsByCountryIfDoesntExist(){
        try {
            Country c = covidCasesServices.getStatisticsByCountry("ciudad 1");
            fail("Este pais no existe en la api");
        } catch (CovidCasesException e) {
            assertEquals("El pais no fue encontrado",e.getMessage());
        }
    }
    @Test
    public void shouldGetStatistics(){
        try {
            List<Country> r= covidCasesServices.getStatistics();
            assertNotNull(r);
            assertTrue(r.size()>0);
        } catch (CovidCasesException e) {
            e.printStackTrace();
        }
    }

}
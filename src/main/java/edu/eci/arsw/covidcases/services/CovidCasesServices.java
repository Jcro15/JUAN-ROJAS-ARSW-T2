package edu.eci.arsw.covidcases.services;

import edu.eci.arsw.covidcases.Exceptions.CovidCasesException;
import edu.eci.arsw.covidcases.model.Country;
import edu.eci.arsw.covidcases.model.Location;

import java.util.List;

public interface CovidCasesServices {
    List<Country> getStatistics() throws CovidCasesException;

    Country getStatisticsByCountry(String country) throws CovidCasesException;

    Location getCountryLocation(String country) throws CovidCasesException;
}

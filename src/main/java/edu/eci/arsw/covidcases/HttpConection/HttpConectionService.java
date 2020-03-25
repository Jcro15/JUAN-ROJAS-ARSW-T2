package edu.eci.arsw.covidcases.HttpConection;

import edu.eci.arsw.covidcases.Exceptions.CovidCasesException;
import edu.eci.arsw.covidcases.model.Country;
import edu.eci.arsw.covidcases.model.CovidStat;

import java.util.HashMap;
import java.util.List;

/**
 * Interfaz que define los servicios de conexion http
 */
public interface HttpConectionService {
    HashMap<String, Country> getStatistics() throws CovidCasesException;

    Country getStatisticsByCountry(String country) throws CovidCasesException;
}

package edu.eci.arsw.covidcases.HttpConection;

import edu.eci.arsw.covidcases.Exceptions.CovidCasesException;
import edu.eci.arsw.covidcases.model.Country;

import java.util.HashMap;

/**
 * Interfaz que define los servicios de conexion http
 */
public interface HttpConectionService {
    /**
     * Retorna las estadisticas de coronavirus de todos los paises con registros despues de consultarlas en una api externa
     * @return una hashmap String,Country con el nombre del pais y un objeto que tiene todas las estadisticas del pais correspondiente
     * @throws CovidCasesException Si la peticion falla
     */
    HashMap<String, Country> getStatistics() throws CovidCasesException;

    /**
     * Retorna las estadisticas de coronavirus de un pais especifico despues de consultarlas en una api externa
     * @param country el pais que se quiere buscar
     * @return el objeto Country con las estadisticas del pais correspondiente
     * @throws CovidCasesException si el pais no se encuentra en la api
     */
    Country getStatisticsByCountry(String country) throws CovidCasesException;
}

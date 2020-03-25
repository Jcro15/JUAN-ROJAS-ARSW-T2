package edu.eci.arsw.covidcases.services;

import edu.eci.arsw.covidcases.Exceptions.CovidCasesException;
import edu.eci.arsw.covidcases.model.Country;
import edu.eci.arsw.covidcases.model.Location;

import java.util.List;

/**
 * Interfaz de la capa de servicios de la aplicacion
 */
public interface CovidCasesServices {
    /**
     *
     * @return las estadisticas de todos los paises con casos decoronavirus registrados
     * @throws CovidCasesException si ocurre un error al buscar las estadisticas
     */
    List<Country> getStatistics() throws CovidCasesException;

    /**
     * Busca y retorna las estadisticas de coronavirus de un pais dado
     * @param country el nombre del pais
     * @return el objeto Country con todas las estadisticas del pais
     * @throws CovidCasesException si no se encuentra el pais
     */
    Country getStatisticsByCountry(String country) throws CovidCasesException;

    /**
     * retorna la localizacion de un pais dado
     * @param country el nombre del pais
     * @return la localizacion de un pais dado
     * @throws CovidCasesException si no se encuentra la localizacion del pais
     */
    Location getCountryLocation(String country) throws CovidCasesException;
}

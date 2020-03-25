package edu.eci.arsw.covidcases.cache;

import edu.eci.arsw.covidcases.cache.impl.Tuple;
import edu.eci.arsw.covidcases.model.Country;

/**
 * Interfaz que establece los servicios que prestara el cache de la aplicacion
 */
public interface CovidCasesCache {


    /**
     * Retorna el objeto Country con los datos de coronavirus de este y el tiempo en el que fue guardado en cache
     * @param name el nombre del pais
     * @return una tupla  Country,Long que representa el pais almacenado y el tiempo en nanosegundos  del momento en que se guardo
     *
     */
    Tuple<Country, Long> getStoredStatisticsByName(String name);

    /**
     * Guarda un pais dado en una estructura de datos concurrente
     * @param countryname el nombre del pais
     * @param country objeto Country que contiene todas las estadisitcas del pais
     */
    void saveStatisticsByCountry(String countryname,Country country);

}

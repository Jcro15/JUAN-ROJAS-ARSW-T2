package edu.eci.arsw.covidcases.cache.impl;

import edu.eci.arsw.covidcases.cache.CovidCasesCache;
import edu.eci.arsw.covidcases.model.Country;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Representacion de cache que utiliza un ConcurrentHashMap para almacenar los resultados obtenidos
 */
@Service
public class CovidCasesCacheImpl implements CovidCasesCache {


    ConcurrentHashMap<String,Tuple<Country,Long>> cacheStats;

    public CovidCasesCacheImpl() {
        this.cacheStats = new ConcurrentHashMap<String,Tuple<Country,Long>>();
    }


    /**
     * Retorna el objeto Country con los datos de coronavirus de este y el tiempo en el que fue guardado en cache
     * @param name el nombre del pais
     * @return una tupla  Country,Long que representa el pais almacenado y el tiempo en nanosegundos  del momento en que se guardo
     *
     */
    @Override
    public Tuple<Country, Long> getStoredStatisticsByName(String name) {
        return cacheStats.get(name);
    }


    /**
     * Guarda un pais dado en una estructura de datos concurrente
     * @param countryname el nombre del pais
     * @param country objeto Country que contiene todas las estadisitcas del pais
     */
    @Override
    public void saveStatisticsByCountry(String countryname, Country country) {
        cacheStats.put(countryname,new Tuple<Country,Long>(country,System.nanoTime()));
    }
}

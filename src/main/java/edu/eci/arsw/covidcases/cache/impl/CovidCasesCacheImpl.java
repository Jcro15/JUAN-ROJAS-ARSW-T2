package edu.eci.arsw.covidcases.cache.impl;

import edu.eci.arsw.covidcases.cache.CovidCasesCache;
import edu.eci.arsw.covidcases.model.Country;
import edu.eci.arsw.covidcases.model.CovidStat;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class CovidCasesCacheImpl implements CovidCasesCache {

    Tuple<CopyOnWriteArrayList<Country>,Long> cacheCountries;

    ConcurrentHashMap<String,Tuple<Country,Long>> cacheStats;

    public CovidCasesCacheImpl() {
        this.cacheStats = new ConcurrentHashMap<String,Tuple<Country,Long>>();
    }



    @Override
    public Tuple<Country, Long> getStoredStatisticsByName(String name) {
        return cacheStats.get(name);
    }



    @Override
    public void saveStatisticsByCountry(String countryname, Country country) {
        cacheStats.put(countryname,new Tuple<Country,Long>(country,System.nanoTime()));
    }
}

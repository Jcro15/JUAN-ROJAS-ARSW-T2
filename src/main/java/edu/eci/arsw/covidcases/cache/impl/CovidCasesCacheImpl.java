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

    ConcurrentHashMap<String,Tuple<List<CovidStat>,Long>> cacheStats;

    public CovidCasesCacheImpl() {
        this.cacheStats = new ConcurrentHashMap<String,Tuple<List<CovidStat>,Long>>();
    }

    @Override
    public Tuple<List<Country>, Long> getStoredStatistics() {
        return null;
    }

    @Override
    public Tuple<List<CovidStat>, Long> getStoredStatisticsByName(String name) {
        return cacheStats.get(name);
    }

    @Override
    public void saveStatistics(List<Country> countries) {
    }

    @Override
    public void saveStatisticsByCountry(String country, List<CovidStat> stats) {
        cacheStats.put(country,new Tuple<List<CovidStat>,Long>(stats,System.nanoTime()));
    }
}

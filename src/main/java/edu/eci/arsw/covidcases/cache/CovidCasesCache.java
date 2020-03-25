package edu.eci.arsw.covidcases.cache;

import edu.eci.arsw.covidcases.cache.impl.Tuple;
import edu.eci.arsw.covidcases.model.Country;
import edu.eci.arsw.covidcases.model.CovidStat;

import java.util.HashMap;
import java.util.List;

public interface CovidCasesCache {


    Tuple<List<Country>,Long>getStoredStatistics();

    Tuple<List<CovidStat> ,Long> getStoredStatisticsByName(String name);

    void saveStatistics(List<Country> countries);

    void saveStatisticsByCountry(String country,List<CovidStat> stats);

}

package edu.eci.arsw.covidcases.cache;

import edu.eci.arsw.covidcases.cache.impl.Tuple;
import edu.eci.arsw.covidcases.model.Country;
import edu.eci.arsw.covidcases.model.CovidStat;

import java.util.HashMap;
import java.util.List;

public interface CovidCasesCache {



    Tuple<Country, Long> getStoredStatisticsByName(String name);

    void saveStatisticsByCountry(String countryname,Country country);

}

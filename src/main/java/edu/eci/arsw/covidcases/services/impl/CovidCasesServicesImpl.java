package edu.eci.arsw.covidcases.services.impl;

import edu.eci.arsw.covidcases.Exceptions.CovidCasesException;
import edu.eci.arsw.covidcases.HttpConection.HttpConectionService;
import edu.eci.arsw.covidcases.cache.CovidCasesCache;
import edu.eci.arsw.covidcases.cache.impl.Tuple;
import edu.eci.arsw.covidcases.model.Country;
import edu.eci.arsw.covidcases.model.CovidStat;
import edu.eci.arsw.covidcases.services.CovidCasesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class CovidCasesServicesImpl implements CovidCasesServices {

    @Autowired
    HttpConectionService httpConectionService;

    @Autowired
    CovidCasesCache covidCasesCache;

    @Override
    public List<Country> getStatistics() throws CovidCasesException {

        HashMap<String,Country> dict=httpConectionService.getStatistics();
        ArrayList<Country> countries=new ArrayList<Country>();

        for (Country country: dict.values()) {
            countries.add(country);

        }
        Collections.sort(countries, Comparator.comparing(Country::getDeaths)
                .thenComparing(Country::getConfirmed)
                .thenComparing(Country::getRecovered).reversed());
        return countries;
    }

    @Override
    public Country getStatisticsByCountry(String country) throws CovidCasesException {
        Tuple<Country,Long> response = null;
        response = covidCasesCache.getStoredStatisticsByName(country);

        if(response == null){
            Country res=httpConectionService.getStatisticsByCountry(country);
            Collections.sort(res.getStatList(), Comparator.comparing(CovidStat::getDeaths)
                    .thenComparing(CovidStat::getConfirmed)
                    .thenComparing(CovidStat::getRecovered).reversed());
            covidCasesCache.saveStatisticsByCountry(country,res);
            return res;
        }
        else{
            Long timeInCache = response.getElem2();
            Long elapsedTime = System.nanoTime() - timeInCache;
            Long time = TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);
            if(time>300){
                Country res=httpConectionService.getStatisticsByCountry(country);
                Collections.sort(res.getStatList(), Comparator.comparing(CovidStat::getDeaths)
                        .thenComparing(CovidStat::getConfirmed)
                        .thenComparing(CovidStat::getRecovered).reversed());
                covidCasesCache.saveStatisticsByCountry(country,res);
                return res;
            }
        }
        return response.getElem1();
    }
}

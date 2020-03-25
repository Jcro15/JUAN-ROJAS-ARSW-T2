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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        return countries;
    }

    @Override
    public List<CovidStat> getStatisticsByCountry(String country) throws CovidCasesException {
        Tuple<List<CovidStat>,Long> response = null;
        response = covidCasesCache.getStoredStatisticsByName(country);

        if(response == null){
            List<CovidStat> res=httpConectionService.getStatisticsByCountry(country);
            covidCasesCache.saveStatisticsByCountry(country,res);
            return res;
        }
        else{
            Long timeInCache = response.getElem2();
            Long elapsedTime = System.nanoTime() - timeInCache;
            Long time = TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);
            if(time>300){
                List<CovidStat> res=httpConectionService.getStatisticsByCountry(country);
                covidCasesCache.saveStatisticsByCountry(country,res);
                return res;
            }
        }
        return response.getElem1();

    }
}

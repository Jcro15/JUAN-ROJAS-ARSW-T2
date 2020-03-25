package edu.eci.arsw.covidcases.HttpConection;

import edu.eci.arsw.covidcases.Exceptions.CovidCasesException;
import edu.eci.arsw.covidcases.model.Location;

public interface HttpConectionLocationService {

    Location getCountryLocation(String country) throws CovidCasesException;
}

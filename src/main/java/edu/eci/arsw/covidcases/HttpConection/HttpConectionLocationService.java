package edu.eci.arsw.covidcases.HttpConection;

import edu.eci.arsw.covidcases.Exceptions.CovidCasesException;
import edu.eci.arsw.covidcases.model.Location;

/**
 * interfaz que representa los servicios que deben ofrecer las instancias
 * de conectores a apis de localizacion
 */
public interface HttpConectionLocationService {
    /**
     * Retorna la localizacion  [longitud,latitud] de un pais dado despues de consultarla en una api externa
     * @param country el nombre del pais del que se desea saber la localizacion
     * @return un objeto Location con las coordenadas del pais obtenidas de la api
     * @throws CovidCasesException si el pais no existe dentro de la api
     */
    Location getCountryLocation(String country) throws CovidCasesException;
}

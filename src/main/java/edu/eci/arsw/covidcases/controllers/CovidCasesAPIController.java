package edu.eci.arsw.covidcases.controllers;

import edu.eci.arsw.covidcases.Exceptions.CovidCasesException;
import edu.eci.arsw.covidcases.services.CovidCasesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controlador API-REST para la raiz statistics, permite hacer get a /statistics y a /statistics/{countryname}
 */
@RestController
@RequestMapping(value = "/statistics")
public class CovidCasesAPIController {
    @Autowired
    CovidCasesServices covidCasesServices=null;

    /**
     * retorna la lista de todos los paises que tienen estadisticas de coronavirus si es exitoso retornar
     * el codigo Accepted, si no representa un error interno del servidor
     * @return Un response entity con el codigo http y la lista de objetos Country en formato JSON
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getStatistics(){
        try {
            return new ResponseEntity<>(covidCasesServices.getStatistics(), HttpStatus.ACCEPTED);
        } catch (CovidCasesException e) {
            Logger.getLogger(CovidCasesAPIController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * retorna el pais con nombre dado con sus  estadisticas de coronavirus.
     * si es exitoso retorna el codigo Accepted, si no el codigo Not Found
     * @param country el nombre del pais que se desea consultar
     * @return Un response entity con el codigo http y un objeto  Country en formato JSON
     */
    @RequestMapping(path = "/{country}",method = RequestMethod.GET)
    public ResponseEntity<?> getStatisticsByCountry(@PathVariable("country") String country){
        try {
            return new ResponseEntity<>(covidCasesServices.getStatisticsByCountry(country), HttpStatus.ACCEPTED);
        } catch (CovidCasesException e) {
            Logger.getLogger(CovidCasesAPIController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

}

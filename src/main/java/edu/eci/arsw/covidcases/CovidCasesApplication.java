package edu.eci.arsw.covidcases;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Clase main de la aplicaion AirportFinder
 */
@SpringBootApplication
@ComponentScan(basePackages = {"edu.eci.arsw.covidcases"})
public class CovidCasesApplication {
    /**
     * Metodo main del proyecto
     * @param args args
     */
    public static void main(String[] args) {
        SpringApplication.run(CovidCasesApplication.class, args);
    }

}
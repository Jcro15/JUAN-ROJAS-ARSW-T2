package edu.eci.arsw.covidcases.Exceptions;

/**
 * Excepcion de para la aplicacion covidcases
 */
public class CovidCasesException extends Exception{
    public CovidCasesException(String message) {
        super(message);
    }

    public CovidCasesException(String message, Throwable cause){
        super(message,cause);
    }
}

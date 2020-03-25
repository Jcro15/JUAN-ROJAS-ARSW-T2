package edu.eci.arsw.covidcases.model;

/**
 * Objeto que representa los datos obtenidos del formato Json
 */
public class Data{

    private CovidStats data;


    public Data() {
    }

    /**
     *
     * @return retorna los datos obtenidos
     */
    public CovidStats getData() {
        return data;
    }

    /**
     *  cambia los datos del objeto
     * @param data los datos nuevos
     */
    public void setData(CovidStats data) {
        this.data = data;
    }
}
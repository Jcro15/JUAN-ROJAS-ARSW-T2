package edu.eci.arsw.covidcases.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un pais y sus estadisticas de coronavirus
 */
public class Country {
    private String countryname;
    private List<CovidStat>statList;
    private long confirmed;
    private long deaths;
    private long recovered;
    private Location location;

    public Country(String countryname) {
        this.countryname = countryname;
        this.confirmed=0;
        this.deaths=0;
        this.recovered=0;
        this.statList=new ArrayList<CovidStat>();
        this.location=new Location();
    }

    /**
     *
     * @return la localizacion del pais
     */
    public Location getLocation() {
        return location;
    }

    /**
     * cambia la localizacion del pais
     * @param location la nueva localizacion
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * añade las caracteristicas de una estadistica al acumulado del pais
     * @param stat la estadistica a añadir
     */
    public void addStat(CovidStat stat){
        confirmed+=stat.getConfirmed();
        deaths+=stat.getDeaths();
        recovered+=stat.getRecovered();
        statList.add(stat);
    }

    /**
     * añade las caracteristicas numericas de una estadistica al acumulado del pais
     * @param stat la estadistica a añadir
     */
    public void addStatistics(CovidStat stat){
        confirmed+=stat.getConfirmed();
        deaths+=stat.getDeaths();
        recovered+=stat.getRecovered();
    }

    /**
     *
     * @return el nombre del pais
     */
    public String getCountryname() {
        return countryname;
    }

    /**
     * cambia el nombre del pais
     * @param countryname el nuevo nombre del pais
     */
    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    /**
     *
     * @return  una lista con las estadisticas de coronavirus especificas
     */
    public List<CovidStat> getStatList() {
        return statList;
    }

    /**
     * cambia la lista de estadisticas del pais
     * @param statList nueva lista de estadisticas
     */
    public void setStatList(List<CovidStat> statList) {
        this.statList = statList;
    }

    /**
     *
     * @return el numero de casos confirmados
     */
    public long getConfirmed() {
        return confirmed;
    }

    /**
     * cambia el numero de casos confirmados
     * @param confirmed el nuevo numero de casos confirmados
     */
    public void setConfirmed(long confirmed) {
        this.confirmed = confirmed;
    }

    /**
     *
     * @return el numero de muertos en el pais por coronavirus
     */
    public long getDeaths() {
        return deaths;
    }

    /**
     * establece el numero de muertos en el pais
     * @param deaths el nuevo numero
     */
    public void setDeaths(long deaths) {
        this.deaths = deaths;
    }

    /**
     *
     * @return el numero de personas recuperadas
     */
    public long getRecovered() {
        return recovered;
    }

    /**
     * cambia el numero de personas recuperadas
     * @param recovered el nuevo numero de personas recuperadas en el pais
     */
    public void setRecovered(long recovered) {
        this.recovered = recovered;
    }
}

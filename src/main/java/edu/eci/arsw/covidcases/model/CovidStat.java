package edu.eci.arsw.covidcases.model;

/**
 * Estadistica de coronavirus
 */
public class CovidStat {
    private String city;
    private String province;
    private String country;
    private long confirmed;
    private long deaths;
    private long recovered;

    /**
     *
     * @return ciudad de medicion
     */
    public String getCity() {
        return city;
    }

    /**
     * cambia la ciudad de medicion
     * @param city la nueva ciudad de medicion
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @return la provincia de la ciudad doonde se midio
     */
    public String getProvince() {
        return province;
    }

    /**
     * cambiar la  provincia de la ciudad doonde se midio
     * @param province la nueva la provincia de la ciudad doonde se midio
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     *
     * @return el pais donde se tomo la estdistica
     */
    public String getCountry() {
        return country;
    }

    /**
     * cambia el pais donde se tomo la estdistica
     * @param country el nuevo pais donde se tomo la estdistica
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     *
     * @return numero de casos confirmados
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
     * @return numero de muertos
     */
    public long getDeaths() {
        return deaths;
    }

    /**
     * cambia el numero de muertos
     * @param deaths el nuevo numero de muertos
     */
    public void setDeaths(long deaths) {
        this.deaths = deaths;
    }

    /**
     *
     * @return numero de recuperados
     */
    public long getRecovered() {
        return recovered;
    }

    /**
     * cambia el numero de recuperados
     * @param recovered el nuevo numero de recuperados
     */
    public void setRecovered(long recovered) {
        this.recovered = recovered;
    }

    /**
     *
     * @return representacion en String del objeto CovidStat
     */
    @Override
    public String toString() {
        return "CovidStat{" +
                "city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", country='" + country + '\'' +
                ", confirmed=" + confirmed +
                ", deaths=" + deaths +
                ", recovered=" + recovered +
                '}';
    }
}

package edu.eci.arsw.covidcases.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Contenedor de objetos CovidStat
 */
public class CovidStats {
    private List<CovidStat> covid19Stats;

    public CovidStats() {
        this.covid19Stats = new ArrayList<CovidStat>();
    }

    /**
     *
     * @return una lista con las estadisticas de coronavirus
     */
    public List<CovidStat> getCovid19Stats() {
        return covid19Stats;
    }

    /**
     * cambia la lista de estadisticas
     * @param covid19Stats la nueva lista
     */
    public void setCovid19Stats(List<CovidStat> covid19Stats) {
        this.covid19Stats = covid19Stats;
    }

    /**
     *
     * @return representacion en String del objeto
     */
    @Override
    public String toString() {
        return "CovidStats{" +
                "covid19Stats=" + covid19Stats +
                '}';
    }
}

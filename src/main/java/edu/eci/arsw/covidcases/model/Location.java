package edu.eci.arsw.covidcases.model;

import java.util.ArrayList;
import java.util.List;

/**
 * objeto que representa la localizacion de un pais
 */
public class Location {

    List<Float> latlng;

    public Location(){
        latlng= new ArrayList<Float>();
    }

    /**
     *
     * @return una lista de dos posiciones con la latitud y longitud de la ubicacion del pais
     */
    public List<Float> getLatlng() {
        return latlng;
    }

    /**
     * cambia la lista de coordenadas del pais
     * @param latlng la nueva lista de coordenadas
     */
    public void setLatlng(List<Float> latlng) {
        this.latlng = latlng;
    }
}

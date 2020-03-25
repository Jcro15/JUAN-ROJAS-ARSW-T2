package edu.eci.arsw.covidcases.model;

import java.util.ArrayList;
import java.util.List;

public class Location {
    List<Float> latlng;

    public Location(){
        latlng= new ArrayList<Float>();
    }

    public List<Float> getLatlng() {
        return latlng;
    }

    public void setLatlng(List<Float> latlng) {
        this.latlng = latlng;
    }
}

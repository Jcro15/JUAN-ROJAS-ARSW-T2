package edu.eci.arsw.covidcases.HttpConection.impl;

import com.google.gson.Gson;
import edu.eci.arsw.covidcases.Exceptions.CovidCasesException;
import edu.eci.arsw.covidcases.HttpConection.HttpConectionService;
import edu.eci.arsw.covidcases.model.Country;
import edu.eci.arsw.covidcases.model.CovidStat;
import edu.eci.arsw.covidcases.model.Data;
import org.springframework.stereotype.Service;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.HashMap;

/**
 * Implementacion de conexion http que consulta los datos de coronavirus de los paises en la api rapidapi
 */
@Service
public class HttpConectionServiceimpl implements HttpConectionService {

    /**
     * Retorna las estadisticas de coronavirus de todos los paises con registros despues de consultarlas en rapidapi
     * @return una hashmap String,Country con el nombre del pais y un objeto que tiene todas las estadisticas del pais correspondiente
     * @throws CovidCasesException Si la peticion falla
     */
    @Override
    public HashMap<String, Country> getStatistics() throws CovidCasesException {
        OkHttpClient client = new OkHttpClient();
        String resp = null;

        Request request = request = new Request.Builder()
                .url("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats")
                .get()
                .addHeader("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "303b39044bmshfa611791d0870cap19a565jsn07312e60679d")
                .build();

        Response res = null;
        try {
            res = client.newCall(request).execute();
            if (res.isSuccessful()) {
                resp= res.body().string();
            }
        } catch (IOException e) {
            throw new CovidCasesException("El pais no fue encontrado");
        }

        Gson gson = new Gson();
        HashMap<String ,Country> dict=new HashMap<String ,Country>();
        Data stats=new Data();
        stats = gson.fromJson(resp,Data.class);
        for (CovidStat stat:stats.getData().getCovid19Stats()) {
            if(dict.containsKey(stat.getCountry())){
                dict.get(stat.getCountry()).addStatistics(stat);
            }
            else {
                dict.put(stat.getCountry(),new Country(stat.getCountry()));
                dict.get(stat.getCountry()).addStatistics(stat);
            }
        }
        return dict;
    }
    /**
     * Retorna las estadisticas de coronavirus de un pais especifico despues de consultarlas en rapidapi
     * @param country el pais que se quiere buscar
     * @return el objeto Country con las estadisticas del pais correspondiente
     * @throws CovidCasesException si el pais no se encuentra en la api
     */
    @Override
    public Country getStatisticsByCountry(String country) throws CovidCasesException {
        OkHttpClient client = new OkHttpClient();
        String resp = null;

        Request request = request = new Request.Builder()
                .url("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats?country="+country)
                .get()
                .addHeader("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "303b39044bmshfa611791d0870cap19a565jsn07312e60679d")
                .build();

        Response res = null;
        try {
            res = client.newCall(request).execute();
            if (res.isSuccessful()) {
                resp= res.body().string();
            }
        } catch (IOException e) {
            throw new CovidCasesException("El pais no fue encontrado");
        }

        if(resp.contains("Country not found. Returning all stats. Please use a country name found in the data property")) {
            throw new CovidCasesException("El pais no fue encontrado");
        }

        Gson gson = new Gson();
        Data stats= new Data();

        stats = gson.fromJson(resp,Data.class);
        Country country1= new Country(country);
        for (CovidStat stat:stats.getData().getCovid19Stats()) {
            country1.addStat(stat);
        }
        return country1;
    }
}



package edu.eci.arsw.covidcases.HttpConection.impl;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import edu.eci.arsw.covidcases.Exceptions.CovidCasesException;
import edu.eci.arsw.covidcases.HttpConection.HttpConectionLocationService;
import edu.eci.arsw.covidcases.model.Location;
import org.json.JSONArray;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class HttpConectionLocationServiceImpl implements HttpConectionLocationService {
    @Override
    public Location getCountryLocation(String country) throws CovidCasesException {

        OkHttpClient client = new OkHttpClient();
        String resp = null;
        Request request = new Request.Builder()
                .url("https://restcountries-v1.p.rapidapi.com/name/"+country)
                .get()
                .addHeader("x-rapidapi-host", "restcountries-v1.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "303b39044bmshfa611791d0870cap19a565jsn07312e60679d")
                .build();
        Response res = null;
        try {
            res = client.newCall(request).execute();
            if (res.isSuccessful()) {
                resp= res.body().string();
            }
        } catch (IOException e) {
            throw new CovidCasesException("Not Found");
        }
        String objeto = new JSONArray(resp).get(0).toString();
        Gson gson = new Gson();
        Location location1= new Location();
        location1 = gson.fromJson(objeto,Location.class);
        return location1;
    }
}

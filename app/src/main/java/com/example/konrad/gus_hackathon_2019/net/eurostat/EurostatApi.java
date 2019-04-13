package com.example.konrad.gus_hackathon_2019.net.eurostat;

import com.example.konrad.gus_hackathon_2019.net.eurostat.model.EurostatDataResponse;
import com.example.konrad.gus_hackathon_2019.util.Util;
import com.jjoe64.graphview.series.DataPoint;

import java.io.IOException;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

public class EurostatApi {
    public static final String base_url = "http://ec.europa.eu/eurostat/wdds/rest/data/v2.1/json/en/";
    public static final String main_url = base_url;

    public static DataPoint[] callData(String dataset, String country) {
        Retrofit instance = EurostatRetrofitClientInstance.getRetrofitInstance();
        EurostatApiAdapter adapter = instance.create(EurostatApiAdapter.class);
        Call<EurostatDataResponse> result = adapter.getDataFromDataSet(String.format("%s&geo=%s", dataset, country));
        Response<EurostatDataResponse> response = null;
        try {
            response = result.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        EurostatDataResponse body = Objects.requireNonNull(response).body();
        return Util.convertToDataPoints(body);
    }

    public static String callDesc(String dataset, String country) {
        Retrofit instance = EurostatRetrofitClientInstance.getRetrofitInstance();
        EurostatApiAdapter adapter = instance.create(EurostatApiAdapter.class);
        Call<EurostatDataResponse> result = adapter.getDataFromDataSet(String.format("%s&geo=%s", dataset, country));
        Response<EurostatDataResponse> response = null;
        try {
            response = result.execute();
        } catch (IOException e) {
            e.printStackTrace();

            return "";
        }
        EurostatDataResponse body = Objects.requireNonNull(response).body();
        return body.label;
    }

    public static String callCountryName(String dataset, String country) {
        Retrofit instance = EurostatRetrofitClientInstance.getRetrofitInstance();
        EurostatApiAdapter adapter = instance.create(EurostatApiAdapter.class);
        Call<EurostatDataResponse> result = adapter.getDataFromDataSet(String.format("%s&geo=%s", dataset, country));
        Response<EurostatDataResponse> response = null;
        try {
            response = result.execute();
        } catch (IOException e) {
            e.printStackTrace();

            return "";
        }
        EurostatDataResponse body = Objects.requireNonNull(response).body();
        return body.dimensions.geo.category.label.get(country);
    }
}

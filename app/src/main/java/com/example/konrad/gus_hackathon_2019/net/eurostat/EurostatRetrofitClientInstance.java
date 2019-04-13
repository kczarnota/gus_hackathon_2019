package com.example.konrad.gus_hackathon_2019.net.eurostat;

import com.example.konrad.gus_hackathon_2019.net.bdlapi.BDLApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EurostatRetrofitClientInstance {
    private static Retrofit retrofit;
    private static final String BASE_URL = EurostatApi.main_url;

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
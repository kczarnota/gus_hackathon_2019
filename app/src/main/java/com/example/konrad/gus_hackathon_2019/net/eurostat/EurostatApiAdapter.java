package com.example.konrad.gus_hackathon_2019.net.eurostat;

import com.example.konrad.gus_hackathon_2019.net.bdlapi.model.BaseResult;
import com.example.konrad.gus_hackathon_2019.net.bdlapi.model.Variable;
import com.example.konrad.gus_hackathon_2019.net.eurostat.model.EurostatDataResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface EurostatApiAdapter {
    @GET
    Call<EurostatDataResponse> getDataFromDataSet(@Url String url);
}
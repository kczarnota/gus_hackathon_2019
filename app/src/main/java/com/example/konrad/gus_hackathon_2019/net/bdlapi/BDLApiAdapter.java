package com.example.konrad.gus_hackathon_2019.net.bdlapi;

import com.example.konrad.gus_hackathon_2019.net.bdlapi.model.BaseResult;
import com.example.konrad.gus_hackathon_2019.net.bdlapi.model.Variable;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface BDLApiAdapter {
    @GET("data/by-variable/{id}/?format=json&unit-level=0")
    Call<BaseResult> getDataById(@Path("id") int id);

    @GET("variables/{id}?format=json")
    Call<Variable> getVariableNameById(@Path("id") int id);
}
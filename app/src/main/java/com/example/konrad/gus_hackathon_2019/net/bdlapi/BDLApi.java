package com.example.konrad.gus_hackathon_2019.net.bdlapi;

import com.example.konrad.gus_hackathon_2019.net.bdlapi.model.BaseResult;
import com.example.konrad.gus_hackathon_2019.net.bdlapi.model.Variable;
import com.example.konrad.gus_hackathon_2019.util.Util;
import com.jjoe64.graphview.series.DataPoint;

import java.io.IOException;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

public class BDLApi {
    public static final String base_url = "https://bdl.stat.gov.pl/api/";
    public static final String api_version = "v1";
    public static final String main_url = base_url + api_version + '/';

    public static DataPoint[] callData(int categoryId) {
        Retrofit instance = BDLRetrofitClientInstance.getRetrofitInstance();
        BDLApiAdapter adapter = instance.create(BDLApiAdapter.class);
        Call<BaseResult> result = adapter.getDataById(categoryId);
        Response<BaseResult> response = null;
        try {
            response = result.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BaseResult body = Objects.requireNonNull(response).body();
        return Util.convertToDataPoints(body);
    }

    public static String callDesc(int categoryId) {
        Retrofit instance = BDLRetrofitClientInstance.getRetrofitInstance();
        BDLApiAdapter adapter = instance.create(BDLApiAdapter.class);
        Call<Variable> result = adapter.getVariableNameById(categoryId);
        Response<Variable> response = null;
        try {
            response = result.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Variable body = Objects.requireNonNull(response).body();
        String out = "";
        if (body.n1 != null) {
            out += body.n1;
        }
        if (body.n2 != null) {
            out += " " + body.n2;
        }
        return out;
    }
}

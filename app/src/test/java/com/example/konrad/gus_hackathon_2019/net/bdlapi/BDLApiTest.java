package com.example.konrad.gus_hackathon_2019.net.bdlapi;

import com.example.konrad.gus_hackathon_2019.net.bdlapi.model.BaseResult;
import com.example.konrad.gus_hackathon_2019.net.bdlapi.model.Result;
import com.example.konrad.gus_hackathon_2019.net.bdlapi.model.Value;

import org.junit.Test;

import java.io.IOException;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

public class BDLApiTest {
    @Test
    public void exampleTest() {
        Retrofit instance = RetrofitClientInstance.getRetrofitInstance();
        BDLApiAdapter adapter = instance.create(BDLApiAdapter.class);
        Call<BaseResult> result = adapter.getDataById(3643);
        try {
            Response<BaseResult> response = result.execute();
            BaseResult body = response.body();
            for (Result res: Objects.requireNonNull(body).getResults()) {
                System.out.println(res.getName());
                for (Value value: res.getValues()) {
                    System.out.println(value.getVal());
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
package com.example.konrad.gus_hackathon_2019.net.eurostat.model;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class EurostatDataResponse {
    @SerializedName("value")
    public Map<Integer, Double> value;

    @SerializedName("dimension")
    public Dimensions dimensions;

}

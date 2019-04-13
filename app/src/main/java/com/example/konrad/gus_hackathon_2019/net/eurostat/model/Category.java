package com.example.konrad.gus_hackathon_2019.net.eurostat.model;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class Category {
    @SerializedName("index")
    public Map<String, Integer> index;
    @SerializedName("label")
    public Map<String, String> label;
}

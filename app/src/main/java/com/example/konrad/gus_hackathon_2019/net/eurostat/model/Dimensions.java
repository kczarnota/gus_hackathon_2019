package com.example.konrad.gus_hackathon_2019.net.eurostat.model;

import com.google.gson.annotations.SerializedName;

public class Dimensions {
    @SerializedName("unit")
    public Dimension unit;
    @SerializedName("time")
    public Dimension time;
    @SerializedName("geo")
    public Dimension geo;
}

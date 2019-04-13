package com.example.konrad.gus_hackathon_2019.net.eurostat.model;

import com.google.gson.annotations.SerializedName;

public class Dimension {
    @SerializedName("label")
    public String label;
    @SerializedName("category")
    public Category category;
}

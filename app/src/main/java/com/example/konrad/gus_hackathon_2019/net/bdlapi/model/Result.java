package com.example.konrad.gus_hackathon_2019.net.bdlapi.model;

import com.google.gson.annotations.SerializedName;

public class Result {
    @SerializedName("id")
    int id;

    @SerializedName("name")
    String name;

    @SerializedName("values")
    Value[] values;

    public Result(int id, String name, Value[] values) {
        this.id = id;
        this.name = name;
        this.values = values;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Value[] getValues() {
        return values;
    }

    public void setValues(Value[] values) {
        this.values = this.values;
    }
}

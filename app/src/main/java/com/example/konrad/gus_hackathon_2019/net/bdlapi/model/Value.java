package com.example.konrad.gus_hackathon_2019.net.bdlapi.model;

import com.google.gson.annotations.SerializedName;

public class Value {
    @SerializedName("year")
    String year;

    @SerializedName("val")
    double val;

    @SerializedName("attrId")
    int attrId;

    public Value(String year, int val, int attrId) {
        this.year = year;
        this.val = val;
        this.attrId = attrId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public double getVal() {
        return val;
    }

    public void setVal(double val) {
        this.val = val;
    }

    public int getAttrId() {
        return attrId;
    }

    public void setAttrId(int attrId) {
        this.attrId = attrId;
    }
}

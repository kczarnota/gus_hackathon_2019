package com.example.konrad.gus_hackathon_2019.net.bdlapi.model;

import com.google.gson.annotations.SerializedName;

public class Variable {
    @SerializedName("id")
    String id;

    @SerializedName("variableId")
    String variableId;

    @SerializedName("n1")
    public String n1;

    @SerializedName("n2")
    public String n2;

    @SerializedName("measureUnitId")
    String measureUnitId;

    @SerializedName("measureUnitName")
    String measureUnitName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVariableId() {
        return variableId;
    }

    public void setVariableId(String variableId) {
        this.variableId = variableId;
    }

    public String getMeasureUnitId() {
        return measureUnitId;
    }

    public void setMeasureUnitId(String measureUnitId) {
        this.measureUnitId = measureUnitId;
    }

    public String getMeasureUnitName() {
        return measureUnitName;
    }

    public void setMeasureUnitName(String measureUnitName) {
        this.measureUnitName = measureUnitName;
    }

    public int[] getYears() {
        return years;
    }

    public void setYears(int[] years) {
        this.years = years;
    }

    public Variable(String id, String variableId, String n1, String n2, String measureUnitId, String measureUnitName, int[] years) {
        this.id = id;
        this.variableId = variableId;
        this.n1 = n1;
        this.n2 = n2;
        this.measureUnitId = measureUnitId;
        this.measureUnitName = measureUnitName;
        this.years = years;
    }

    @SerializedName("years")
    int[] years;
}

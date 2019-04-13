package com.example.konrad.gus_hackathon_2019.net.bdlapi.model;

import com.google.gson.annotations.SerializedName;

public class BaseResult {
    @SerializedName("totalRecords")
    int totalRecords;

    @SerializedName("variableId")
    int variableId;

    @SerializedName("measureUnitId")
    int measureUnitId;

    @SerializedName("aggregateId")
    int aggregateId;

    @SerializedName("lastUpdate")
    String lastUpdate;

    Result[] results;

    public BaseResult(int totalRecords, int variableId, int measureUnitId, int aggregateId, String lastUpdate, Result[] results) {
        this.totalRecords = totalRecords;
        this.variableId = variableId;
        this.measureUnitId = measureUnitId;
        this.aggregateId = aggregateId;
        this.lastUpdate = lastUpdate;
        this.results = results;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public int getVariableId() {
        return variableId;
    }

    public void setVariableId(int variableId) {
        this.variableId = variableId;
    }

    public int getMeasureUnitId() {
        return measureUnitId;
    }

    public void setMeasureUnitId(int measureUnitId) {
        this.measureUnitId = measureUnitId;
    }

    public int getAggregateId() {
        return aggregateId;
    }

    public void setAggregateId(int aggregateId) {
        this.aggregateId = aggregateId;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Result[] getResults() {
        return results;
    }

    public void setResults(Result[] results) {
        this.results = results;
    }
}

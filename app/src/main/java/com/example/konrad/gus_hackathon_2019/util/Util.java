package com.example.konrad.gus_hackathon_2019.util;

import android.support.v4.util.Pair;

import com.example.konrad.gus_hackathon_2019.net.bdlapi.model.BaseResult;
import com.example.konrad.gus_hackathon_2019.net.bdlapi.model.Result;
import com.example.konrad.gus_hackathon_2019.net.bdlapi.model.Value;
import com.example.konrad.gus_hackathon_2019.net.eurostat.model.EurostatDataResponse;
import com.jjoe64.graphview.series.DataPoint;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import static com.example.konrad.gus_hackathon_2019.net.eurostat.EurostatUtil.convertEurostatCube;

public class Util<min> {
    public static DataPoint[] convertToDataPoints(BaseResult input) {
        List<DataPoint> points = new LinkedList<>();
        for (Result res : Objects.requireNonNull(input).getResults()) {
            for (Value value : res.getValues()) {
                DataPoint dataPoint = new DataPoint(Double.parseDouble(value.getYear()), value.getVal());
                points.add(dataPoint);
            }
        }
        return points.toArray(new DataPoint[0]);
    }

    public static DataPoint[] convertToDataPoints(EurostatDataResponse input) {
        List<DataPoint> points = new LinkedList<>();
        List<android.support.v4.util.Pair<Integer, Double>> converted = convertEurostatCube(input);
        for (Pair<Integer, Double> dataPair : converted) {
            DataPoint dataPoint = new DataPoint(dataPair.first, dataPair.second);
            points.add(dataPoint);
        }
        return points.toArray(new DataPoint[0]);
    }

    public static double getMin(DataPoint[] input) {
        double min = Integer.MAX_VALUE;
        for (DataPoint res : input) {
            if (res.getY() < min) {
                min = res.getY();
            }

        }
        return min;
    }

    public static double getMax(DataPoint[] input) {
        double max = Integer.MIN_VALUE;
        for (DataPoint res : input) {
            if (res.getY() > max) {
                max = res.getY();
            }

        }
        return max;
    }

}

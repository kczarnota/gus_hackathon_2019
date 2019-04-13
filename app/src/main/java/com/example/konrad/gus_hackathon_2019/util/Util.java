package com.example.konrad.gus_hackathon_2019.util;

import com.example.konrad.gus_hackathon_2019.net.bdlapi.model.BaseResult;
import com.example.konrad.gus_hackathon_2019.net.bdlapi.model.Result;
import com.example.konrad.gus_hackathon_2019.net.bdlapi.model.Value;
import com.jjoe64.graphview.series.DataPoint;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Util {
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

    public static double getMin(BaseResult input) {
        double min = Integer.MAX_VALUE;
        for (Result res : Objects.requireNonNull(input).getResults()) {
            for (Value value : res.getValues()) {
                if (value.getVal() < min) {
                    min = value.getVal();
                }

            }
        }
        return min;
    }

    public static double getMax(BaseResult input) {
        double max = Integer.MIN_VALUE;
        for (Result res : Objects.requireNonNull(input).getResults()) {
            for (Value value : res.getValues()) {
                if (value.getVal() > max) {
                    max = value.getVal();
                }

            }
        }
        return max;
    }

}

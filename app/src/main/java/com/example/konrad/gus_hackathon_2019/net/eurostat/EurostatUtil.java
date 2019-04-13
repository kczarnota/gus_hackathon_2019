package com.example.konrad.gus_hackathon_2019.net.eurostat;

import android.arch.lifecycle.CompositeGeneratedAdaptersObserver;
import android.support.annotation.NonNull;
import android.support.v4.util.Pair;

import com.example.konrad.gus_hackathon_2019.net.eurostat.model.EurostatDataResponse;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class EurostatUtil {
    public static List<Pair<Integer, Double>> convertEurostatCube(EurostatDataResponse data) {
        List<Pair<Integer, Double>> output = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : data.dimensions.time.category.index.entrySet()) {
            Integer year = Integer.valueOf(entry.getKey());
            Integer dataIndex = entry.getValue();
            Double dataValue = data.value.get(dataIndex);
            if (dataValue != null) {
                output.add(new Pair<>(year, dataValue));
            }
        }
        return output;
    }
}

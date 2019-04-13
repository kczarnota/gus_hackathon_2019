package com.example.konrad.gus_hackathon_2019.net.eurostat;

import android.provider.ContactsContract;

import com.jjoe64.graphview.series.DataPoint;

import org.junit.Test;

import static org.junit.Assert.*;

public class EurostatApiTest {
    @Test
    public void EurostatTest() {
        DataPoint[] points = EurostatApi.callData("tran_r_avpa_om?tra_meas=PAS_CRD&precision=1", "PL");
        for (DataPoint point : points) {
            System.out.println(String.format("x=%s y=%s", point.getX(), point.getY()));
        }
    }

}
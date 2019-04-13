package com.example.konrad.gus_hackathon_2019;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.konrad.gus_hackathon_2019.net.bdlapi.BDLApiAdapter;
import com.example.konrad.gus_hackathon_2019.net.bdlapi.RetrofitClientInstance;
import com.example.konrad.gus_hackathon_2019.net.bdlapi.model.BaseResult;
import com.example.konrad.gus_hackathon_2019.net.bdlapi.model.Variable;
import com.example.konrad.gus_hackathon_2019.util.Util;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;


import java.io.IOException;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PlotActivity extends AppCompatActivity {
    GraphView graph;
    TextView plot_desc;
    ToggleButton change_plot_type;
    boolean bar_plot = false;
    private BaseResult body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plot);

        Intent i = getIntent();
        Toast.makeText(this, i.getStringExtra(CameraActivity.NAME_EXTRA), Toast.LENGTH_SHORT).show();

        plot_desc = findViewById(R.id.plot_desc);
        change_plot_type = findViewById(R.id.toggle_plot_type);
        change_plot_type.setOnClickListener(view -> togglePlotType());
        graph = findViewById(R.id.graph);
        Retrofit instance = RetrofitClientInstance.getRetrofitInstance();
        BDLApiAdapter adapter = instance.create(BDLApiAdapter.class);
        Call<BaseResult> result = adapter.getDataById(1234);
        Response<BaseResult> response = null;
        try {
            response = result.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.body = Objects.requireNonNull(response).body();
        DataPoint[] dataPoints = Util.convertToDataPoints(body);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(dataPoints);


        graph.getViewport().setScalable(true);
        graph.getViewport().setScalableY(true);

        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(0);
        graph.getViewport().setMaxY(Util.getMax(body));

        graph.addSeries(series);

        Call<Variable> result_next = adapter.getVariableNameById(1234);
        Response<Variable> response_next = null;
        try {
            response_next = result_next.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Variable v = response_next.body();
        String s = String.format("%s (%s)", v.getN(), v.getMeasureUnitName());

        plot_desc.setText(s);

    }

    void togglePlotType() {
        this.graph.removeAllSeries();
        DataPoint[] dataPoints = Util.convertToDataPoints(body);
        if (this.bar_plot == false) {
            BarGraphSeries<DataPoint> series = new BarGraphSeries<>(dataPoints);
            series.setSpacing(20);
            series.setDrawValuesOnTop(true);
            series.setValuesOnTopColor(Color.RED);

            series.setValueDependentColor(new ValueDependentColor<DataPoint>() {
                @Override
                public int get(DataPoint data) {
                    return Color.rgb((int) data.getX() * 255 / 4, (int) Math.abs(data.getY() * 255 / 6), 100);
                }
            });
            this.graph.addSeries(series);
        } else {
            LineGraphSeries<DataPoint> series = new LineGraphSeries<>(dataPoints);
            this.graph.addSeries(series);
        }

        this.bar_plot = !this.bar_plot;
    }
}

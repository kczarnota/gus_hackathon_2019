package com.example.konrad.gus_hackathon_2019;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.konrad.gus_hackathon_2019.net.bdlapi.BDLApi;
import com.example.konrad.gus_hackathon_2019.net.eurostat.EurostatApi;
import com.example.konrad.gus_hackathon_2019.util.Util;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.Random;

import static com.example.konrad.gus_hackathon_2019.CameraActivity.NAME_EXTRA;
import static com.example.konrad.gus_hackathon_2019.mapping.ClassToCategoriesMaps.COUNTRY_CODES;
import static com.example.konrad.gus_hackathon_2019.mapping.ClassToCategoriesMaps.bdlVariableFromClass;
import static com.example.konrad.gus_hackathon_2019.mapping.ClassToCategoriesMaps.eurostatUrlFromClass;

public class PlotActivity extends AppCompatActivity {
    GraphView graph;
    TextView plot_desc;
    ToggleButton change_plot_type;
    boolean bar_plot = false;
    private DataPoint[] dataPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plot);
        plot_desc = findViewById(R.id.plot_desc);
        graph = (GraphView) findViewById(R.id.graph);

    }

    protected void onResume() {
        super.onResume();

        Intent i = getIntent();
        int class_id = i.getExtras().getInt(NAME_EXTRA);

        this.dataPoints = chooseAndPrepareData(class_id);

        change_plot_type = (ToggleButton) findViewById(R.id.toggle_plot_type);
        change_plot_type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                togglePlotType();
            }
        });


        if (dataPoints != null) {
            LineGraphSeries<DataPoint> series = new LineGraphSeries<>(dataPoints);

            graph.getViewport().setScalable(true);
            graph.getViewport().setScalableY(true);

            graph.getViewport().setYAxisBoundsManual(true);
            graph.getViewport().setMinY(0);
            graph.getViewport().setMaxY(Util.getMax(dataPoints));

            graph.addSeries(series);
        } else {
            Toast.makeText(this, "It seems that you don't have internet connection", Toast.LENGTH_SHORT).show();
            Button refreshBtn = findViewById(R.id.refresh);
            refreshBtn.setVisibility(View.VISIBLE);
            refreshBtn.setOnClickListener(v -> {
                this.dataPoints = EurostatApi.callData("tran_r_avpa_om?tra_meas=PAS_CRD&precision=1", "PL");

                if (dataPoints != null) {
                    LineGraphSeries<DataPoint> series = new LineGraphSeries<>(dataPoints);

                    graph.getViewport().setScalable(true);
                    graph.getViewport().setScalableY(true);

                    graph.getViewport().setYAxisBoundsManual(true);
                    graph.getViewport().setMinY(0);
                    graph.getViewport().setMaxY(Util.getMax(dataPoints));

                    graph.addSeries(series);
                    refreshBtn.setVisibility(View.INVISIBLE);
                } else {
                    Toast.makeText(this, "It seems that you don't have internet connection", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    void togglePlotType() {
        this.graph.removeAllSeries();
        if (!this.bar_plot) {
            BarGraphSeries<DataPoint> series = new BarGraphSeries<>(this.dataPoints);
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
            LineGraphSeries<DataPoint> series = new LineGraphSeries<>(this.dataPoints);
            this.graph.addSeries(series);
        }

        this.bar_plot = !this.bar_plot;
    }

    DataPoint[] chooseAndPrepareData(int class_id) {
        Random r = new Random();

        boolean tryEurostat = false;

        if (r.nextDouble() < 0.5) {
            tryEurostat = true;
        }

        if (tryEurostat) {
            String url = eurostatUrlFromClass(class_id);
            if (url != null) {
                Random ra = new Random();
                int code = ra.nextInt() % COUNTRY_CODES.length;
                String desc = String.format("%s in %s", EurostatApi.callDesc(url, COUNTRY_CODES[code]), EurostatApi.callCountryName(url, COUNTRY_CODES[code]));
                plot_desc.setText(desc);
                return EurostatApi.callData(url, COUNTRY_CODES[code]);
            }
        }
        int variable = bdlVariableFromClass(class_id);
        if (variable != 0) {
            String desc = String.format("%s in %s", BDLApi.callDesc(variable));
            plot_desc.setText(desc);
            return BDLApi.callData(variable);
        }

        return new DataPoint[0];
    }
}

package com.example.konrad.gus_hackathon_2019;

import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.konrad.gus_hackathon_2019.net.eurostat.EurostatApi;
import com.example.konrad.gus_hackathon_2019.util.Util;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

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

        plot_desc = (TextView) findViewById(R.id.plot_desc);
        change_plot_type = (ToggleButton) findViewById(R.id.toggle_plot_type);
        change_plot_type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                togglePlotType();
            }
        });
        graph = (GraphView) findViewById(R.id.graph);

        this.dataPoints = EurostatApi.callData("tran_r_avpa_om?tra_meas=PAS_CRD&precision=1", "PL");

        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(dataPoints);

        graph.getViewport().setScalable(true);
        graph.getViewport().setScalableY(true);

        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(0);
        graph.getViewport().setMaxY(Util.getMax(dataPoints));

        graph.addSeries(series);


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
}

package com.example.ray.achartexample;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;


import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.AbstractChart;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer.FillOutsideLine;

public class MainActivity extends AppCompatActivity {

    private String[] month = new String[]{
            "jan", "feb", "mar", "apr", "jul", "aug", "sep", "oct"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawChart();

    }

    private void drawChart() {
        int[] x_values = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] income = {2000, 2500, 2700, 3000, 2800, 3500, 3700, 3800};
        int[] expense = {1800, 2300, 2500, 2800, 2600, 3000, 3300, 3400};

        XYSeries incomeSeries = new XYSeries("Income");
        XYSeries expenseSeries = new XYSeries("Expence");
        for (int i = 0; i < x_values.length; i++) {
            incomeSeries.add(x_values[i], income[i]);
            expenseSeries.add(x_values[i], expense[i]);
        }

        XYMultipleSeriesDataset xyMultipleSeriesDataset = new XYMultipleSeriesDataset();
        xyMultipleSeriesDataset.addSeries(incomeSeries);
        xyMultipleSeriesDataset.addSeries(expenseSeries);

        XYSeriesRenderer incomeRenderer = new XYSeriesRenderer();
        incomeRenderer.setColor(Color.RED);
        incomeRenderer.setPointStyle(PointStyle.CIRCLE);
        incomeRenderer.setFillPoints(true);
        incomeRenderer.setLineWidth(3);
        incomeRenderer.setDisplayChartValues(true);


        FillOutsideLine fill = new FillOutsideLine(FillOutsideLine.Type.BOUNDS_ALL);
        fill.setColor(Color.GREEN);
        incomeRenderer.addFillOutsideLine(fill);


        XYSeriesRenderer expenceRenderer = new XYSeriesRenderer();
        expenceRenderer.setColor(Color.YELLOW);
        expenceRenderer.setPointStyle(PointStyle.CIRCLE);
        expenceRenderer.setFillPoints(true);
        expenceRenderer.setLineWidth(3);
        expenceRenderer.setDisplayChartValues(true);


        XYMultipleSeriesRenderer multiRenderer = new XYMultipleSeriesRenderer();
        multiRenderer.setXLabels(0);
        multiRenderer.setChartTitle("Expence Chart");
        multiRenderer.setYTitle("Amount in Dollars");
        multiRenderer.setZoomButtonsVisible(true);
        multiRenderer.setShowGrid(true);
        multiRenderer.setShowGridX(true);
        multiRenderer.setShowGridY(true);
        multiRenderer.setMarginsColor(Color.argb(0x00, 0xff, 0x00, 0x00));

        for (int i = 0; i < x_values.length; i++) {
            multiRenderer.addXTextLabel(i + 1, month[i]);
        }
        multiRenderer.addSeriesRenderer(incomeRenderer);
        multiRenderer.addSeriesRenderer(expenceRenderer);

        LinearLayout chartContainer = (LinearLayout) findViewById(R.id.chart_container);

        GraphicalView newChart=CustomLineChart.getNewInstance(getBaseContext(),xyMultipleSeriesDataset,multiRenderer);
        chartContainer.addView(newChart);

    }



}



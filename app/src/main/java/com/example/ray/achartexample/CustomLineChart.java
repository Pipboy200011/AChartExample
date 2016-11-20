package com.example.ray.achartexample;

import android.content.Context;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.AbstractChart;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

/**
 * Created by Ray on 20.11.2016.
 */

//http://danielkvist.net/code/piechart-with-achartengine-in-android



public class CustomLineChart extends GraphicalView {

    public CustomLineChart(Context context, AbstractChart chart) {
        super(context, chart);
    }

    public static GraphicalView getNewInstance(Context context, XYMultipleSeriesDataset dataset, XYMultipleSeriesRenderer renderer)
    {
        return  ChartFactory.getLineChartView(context, dataset, renderer);
    }


}

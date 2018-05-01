package com.example.kathleenbaert.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

/**
 * Created by kathleenbaert on 4/8/18.
 */

public class SpeedGraph extends AppCompatActivity {

    LineGraphSeries<DataPoint> series;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.graph_layout );
        JSONData jsonData = JSONData.jsonData;
        double x, y;
        GraphView graph = (GraphView) findViewById( R.id.graph );
        int[] mColors = {Color.parseColor( "#e6194b" ), Color.parseColor( "#3cb44b" ), Color.parseColor( "#ffe119" ),
                Color.parseColor( "#0082c8" ), Color.parseColor( "#f58231" ), Color.parseColor( "#911eb4" ),
                Color.parseColor( "#46f0f0" ), Color.parseColor( "#f032e6" ), Color.parseColor( "#d2f53c" ),
                Color.parseColor( "#fabebe" ), Color.parseColor( "#008080" ), Color.parseColor( "#e6beff" ),
                Color.parseColor( "#aa6e28" ), Color.parseColor( "#fffac8" ), Color.parseColor( "#800000" ),
                Color.parseColor( "#aaffc3" ), Color.parseColor( "#808000" ), Color.parseColor( "#ffd8b1" ),
                Color.parseColor( "#000080" ), Color.parseColor( "#808080" ), Color.parseColor( "#000000" )};


        series = new LineGraphSeries<DataPoint>();
        series.setColor( mColors[0] );
        x = 0;

        series.setTitle( "Speed Graph" );
        for (int i = 0; i < jsonData.getSpeedHistorical().size(); i++) {
            x += .1;
            y = jsonData.getSpeedHistorical().get( i );
            series.appendData( new DataPoint( x, y ), true, jsonData.getSpeedHistorical().size());
        }
        graph.addSeries( series );
        graph.getLegendRenderer().setVisible( true );
        graph.getLegendRenderer().setAlign( LegendRenderer.LegendAlign.TOP );
        graph.getGridLabelRenderer().setLabelFormatter( new DefaultLabelFormatter() {
            @Override
            public String formatLabel(double value, boolean isValueX) {
                if (isValueX) {
                    // show normal x values
                    return super.formatLabel( value, isValueX ) + " mins";
                } else {
                    // show currency for y values
                    return super.formatLabel( value, isValueX ) + " MPH";
                }
            }


        } );
    }
}

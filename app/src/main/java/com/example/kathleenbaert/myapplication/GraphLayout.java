package com.example.kathleenbaert.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;

import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by kathleenbaert on 4/8/18.
 */

public class GraphLayout extends AppCompatActivity {

    LineGraphSeries<DataPoint> series;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.graph_layout );

        final GraphAccessorsMutators graphAccessorsMutators = new GraphAccessorsMutators().graphAccessorsMutators;
        double x, y;
        int counter;
        GraphView graph = (GraphView) findViewById( R.id.graph );
        int [] mColors = {Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE};
        ArrayList<ArrayList<Double>> currData = graphAccessorsMutators.getArrayLists();


        for (int i = 0; i < graphAccessorsMutators.getNumOfSensors(); i++) {
            series = new LineGraphSeries<DataPoint>(  );
            series.setColor(mColors[i % graphAccessorsMutators.getNumOfSensors()]);
            x = 0;
            counter = 0;
            y = currData.get( i ).get( 0 );
            for(Double d : currData.get( i )){
                x += .1;
                y = d;
                counter++;
                series.appendData( new DataPoint( x, y ), true,  counter);
            }
            graph.addSeries( series );
        }

        graph.getGridLabelRenderer().setLabelFormatter( new DefaultLabelFormatter() {
            @Override
            public String formatLabel(double value, boolean isValueX) {
                if (isValueX) {
                    // show normal x values
                    return super.formatLabel( value, isValueX ) + graphAccessorsMutators.getxLabel();
                } else {
                    // show currency for y values
                    return super.formatLabel( value, isValueX ) + graphAccessorsMutators.getyLabel();
                }
            }


        } );
    }
}

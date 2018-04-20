package com.example.kathleenbaert.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

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


        double x, y;
        x = 0;
        Random random = new Random();
        int [] values1 = new int [50];
        values1[0] = 100;
        for(int i = 1; i < values1.length; i++){
            //works for test data
            values1[i] = values1[i - 1] - random.nextInt(2);

         }

        GraphView graph = (GraphView) findViewById( R.id.graph );
        series = new LineGraphSeries<DataPoint>();
        series.setColor( Color.GREEN );
        for (int i = 0; i < values1.length; i++) {
            x += .1;
            y=values1[i];
            series.appendData( new DataPoint( x, y ), true, values1.length);

        }
        graph.addSeries( series );
        x = 0;

        int [] values = new int [50];
        values[0] = 100;
        for(int i = 1; i < values.length; i++){
            //works for test data
            values[i] = values[i - 1] - random.nextInt(2);

        }
        series = new LineGraphSeries<DataPoint>();
        series.setColor( Color.BLUE );
        for (int i = 0; i < values.length; i++) {
            x += .1;
            y=values[i];
            series.appendData( new DataPoint( x, y ), true, values.length);

        }
        graph.addSeries( series );

    }


}

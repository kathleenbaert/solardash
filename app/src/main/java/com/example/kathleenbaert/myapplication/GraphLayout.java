package com.example.kathleenbaert.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

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

        x = -5;
        GraphView graph = (GraphView) findViewById( R.id.graph );
        series = new LineGraphSeries<DataPoint>();
        for (int i = 0; i < 500; i++) {
            x += .1;
            y = Math.sin( x );
            series.appendData( new DataPoint( x, y ), true, 500);

        }
        graph.addSeries( series );

    }


}

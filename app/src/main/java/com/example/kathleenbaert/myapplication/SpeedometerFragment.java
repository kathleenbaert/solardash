package com.example.kathleenbaert.myapplication;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by kathleenbaert on 11/1/17.
 */

public class SpeedometerFragment extends Fragment {

    View myView;
    static Handler mHandler;
    JSONData jsonData = JSONData.jsonData;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate( R.layout.speedometer_dash, container, false );
        this.mHandler = new Handler();
        m_Runnable.run();


        Button button = (Button) myView.findViewById( R.id.button );
        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( getActivity(), SpeedGraph.class );
                startActivity( intent );
            }
        } );
        return myView;
    }

    public final Runnable m_Runnable = new Runnable() {

        public void run()
        {
            SpeedometerFragment.this.mHandler.postDelayed( m_Runnable, 1000 );
            TextView nameTextField = (TextView) myView.findViewById( R.id.speed );
            double speed = jsonData.getSpeedCurr();
            nameTextField.setText( speed + " MPH" );
            ImageView image = (ImageView) myView.findViewById( R.id.speedometer );
            if (speed < 0) {
                image.setImageResource( R.drawable.speed0 );
            } else if (speed < 2) {
                image.setImageResource( R.drawable.speed1 );
            } else if (speed < 4) {
                image.setImageResource( R.drawable.speed2 );
            } else if (speed < 6) {
                image.setImageResource( R.drawable.speed3 );
            } else if (speed < 8) {
                image.setImageResource( R.drawable.speed4 );
            } else if (speed < 10) {
                image.setImageResource( R.drawable.speed5 );
            } else if (speed < 12) {
                image.setImageResource( R.drawable.speed6 );
            } else if (speed < 14) {
                image.setImageResource( R.drawable.speed7 );
            } else if (speed < 16) {
                image.setImageResource( R.drawable.speed8 );
            } else if (speed < 18) {
                image.setImageResource( R.drawable.speed9 );
            } else if (speed < 20) {
                image.setImageResource( R.drawable.speed10 );
            } else if (speed < 22) {
                image.setImageResource( R.drawable.speed11 );
            } else if (speed < 24) {
                image.setImageResource( R.drawable.speed12 );
            } else if (speed < 26) {
                image.setImageResource( R.drawable.speed13 );
            } else if (speed < 28) {
                image.setImageResource( R.drawable.speed14 );
            } else if (speed < 30) {
                image.setImageResource( R.drawable.speed15 );
            } else if (speed < 32) {
                image.setImageResource( R.drawable.speed16 );
            } else if (speed < 34) {
                image.setImageResource( R.drawable.speed17 );
            } else if (speed < 36) {
                image.setImageResource( R.drawable.speed18 );
            } else {
                image.setImageResource( R.drawable.speed19 );
            }
        };
    };
}
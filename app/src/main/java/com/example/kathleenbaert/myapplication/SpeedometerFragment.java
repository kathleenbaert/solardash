package com.example.kathleenbaert.myapplication;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        return myView;
    }
    static int i = 0;
    public final Runnable m_Runnable = new Runnable()
    {
        public void run()

        {
            SpeedometerFragment.this.mHandler.postDelayed(m_Runnable,1000);

            TextView nameTextField = (TextView) myView.findViewById( R.id.speed );

            nameTextField.setText(jsonData.getSpeedCurr()+"");
            i++;
        }

    };

}


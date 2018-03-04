package com.example.kathleenbaert.myapplication;

import android.app.AlertDialog;
import android.app.Fragment;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by kathleenbaert on 11/1/17.
 */

public class BatteryFragment extends Fragment {

    View myView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.battery_dash, container, false);

        final Context context = myView.getContext();

        final JSONData d = new JSONData();

        TextView firstVolt = myView.findViewById(R.id.volt1);
        firstVolt.setText("Battery 1 Voltage: " + Double.toString( d.dataInstance.getVoltage() ) );

        final Button voltButton1 = myView.findViewById( R.id.voltButton1);

        return myView;
    }
}

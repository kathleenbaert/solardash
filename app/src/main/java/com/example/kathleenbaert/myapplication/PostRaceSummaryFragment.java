package com.example.kathleenbaert.myapplication;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
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

public class PostRaceSummaryFragment extends Fragment {

    View myView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.postracesummary_dash, container, false);
        myView.getId();
        final Context context = myView.getContext();

        final JSONData d = new JSONData();

        Button cButton = myView.findViewById( R.id.cButton );
        Button fButton = myView.findViewById( R.id.fButton );
        Button batteryButton = myView.findViewById( R.id.batteryButton );
        Button voltButton = myView.findViewById( R.id.voltButton );

        cButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

                // set title
                alertDialogBuilder.setTitle("Wheel 1 Temp Celsius Recent Activity");

                double [] tempCArray = d.dataInstance.getTempFArray();
                String message = "";
                for (int i = 0; i < tempCArray.length; i++) {
                    message += ("\n" + tempCArray[i]);
                }
                alertDialogBuilder.setMessage(message);
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });
        fButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

                // set title
                alertDialogBuilder.setTitle("Wheel 1 Temp Fahrenheit Recent Activity");

                double [] tempFArray = d.dataInstance.getTempFArray();
                String message = "";
                for (int i = 0; i < tempFArray.length; i++) {
                    message += ("\n" + tempFArray[i]);
                }
                alertDialogBuilder.setMessage(message);
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });
        batteryButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

                // set title
                alertDialogBuilder.setTitle("Battery 1 Voltage Recent Activity");

                double [] voltageArray = d.dataInstance.getVoltageArray();
                String message = "";
                for (int i = 0; i < voltageArray.length; i++) {
                    message += ("\n" + voltageArray[i]);
                }
                alertDialogBuilder.setMessage(message);
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });
        voltButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

                // set title
                alertDialogBuilder.setTitle("Solar Array 1 Amps Recent Activity");

                double [] ampsArray = d.dataInstance.getAmpsArray();
                String message = "";
                for (int i = 0; i < ampsArray.length; i++) {
                    message += ("\n" + ampsArray[i]);
                }
                alertDialogBuilder.setMessage(message);
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });

        return myView;
    }

}

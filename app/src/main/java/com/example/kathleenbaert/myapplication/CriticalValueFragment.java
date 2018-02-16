package com.example.kathleenbaert.myapplication;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by kathleenbaert on 11/1/17.
 */

public class CriticalValueFragment extends Fragment {
    private final String TAG = "CriticalValueFragment";
    View myView;
    String speedWarning, speedCritical;
    String tempWarning, tempCritical;
    String batteryWarning, batteryCritical;
    String voltageWarning, voltageCritical;


    private DrawerLayout drawerLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate( R.layout.critical_values_dash, container, false );
        textViews();

        return myView;
    }



    private void textViews() {
        Button saveButton = (Button) myView.findViewById( R.id.save_button );
        saveButton.setOnClickListener( get_edit_view_button_listener );

    }


    private Button.OnClickListener get_edit_view_button_listener = new Button.OnClickListener() {
        public void onClick(View v) {
            speedWarning = myView.findViewById( R.id.speed_warning ).toString();
            Log.d(TAG, "Speed warning: " + speedWarning );
            Snackbar snackbar = Snackbar.make( myView, "Saved numbers", Snackbar.LENGTH_SHORT );
            snackbar.show();
        }
    };
}


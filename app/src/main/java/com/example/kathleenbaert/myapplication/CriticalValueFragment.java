package com.example.kathleenbaert.myapplication;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by kathleenbaert on 11/1/17.
 */

public class CriticalValueFragment extends Fragment {
    private final String TAG = "CriticalValueFragment";
    View myView;
    EditText editText;
    Context context;
    static CriticalValues cv = new CriticalValues();
    private DrawerLayout drawerLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate( R.layout.critical_values_dash, container, false );
        context = myView.getContext();
        loadSavedPreferences();
        textViews();
        return myView;

    }
    private void textViews() {
        Button saveButton = (Button) myView.findViewById( R.id.save_button );
        saveButton.setOnClickListener( get_edit_view_button_listener );

    }

    private void savePreferences(String key, String value) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences( context );
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString( key, value );
        editor.commit();
    }

    private void loadSavedPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences( context );
        editText = myView.findViewById( R.id.speed_warning );
        String value = sharedPreferences.getString( "speedWarning", "0" );
        editText.setText( value );

        editText = myView.findViewById( R.id.speed_critical );
        value = sharedPreferences.getString( "speedCritical", "0" );
        editText.setText( value );

        editText = myView.findViewById( R.id.temp_warning );
        value = sharedPreferences.getString( "tempWarning", "0" );
        editText.setText( value );

        editText = myView.findViewById( R.id.temp_critical );
        value = sharedPreferences.getString( "tempCritical", "0" );
        editText.setText( value );

        editText = myView.findViewById( R.id.battery_warning );
        value = sharedPreferences.getString( "batteryWarning", "0" );
        editText.setText( value );

        editText = myView.findViewById( R.id.battery_critical );
        value = sharedPreferences.getString( "batteryCritical", "0" );
        editText.setText( value );

        editText = myView.findViewById( R.id.voltage_warning );
        value = sharedPreferences.getString( "voltageWarning", "0" );
        editText.setText( value );

        editText = myView.findViewById( R.id.voltage_critical );
        value = sharedPreferences.getString( "voltageCritical", "0" );
        editText.setText( value );
    }

    private Button.OnClickListener get_edit_view_button_listener = new Button.OnClickListener() {
        public void onClick(View v) {
            editText = myView.findViewById( R.id.speed_warning );
            cv.setSpeedWarning( Integer.parseInt( editText.getText().toString() ) );
            savePreferences( "speedWarning", editText.getText().toString() );

            editText = myView.findViewById( R.id.speed_critical );
            cv.setSpeedCritical( Integer.parseInt( editText.getText().toString() ) );
            savePreferences( "speedCritical", editText.getText().toString() );

            editText = myView.findViewById( R.id.temp_warning );
            cv.setTempWarning( Integer.parseInt( editText.getText().toString() ) );
            savePreferences( "tempWarning", editText.getText().toString() );

            editText = myView.findViewById( R.id.temp_critical );
            cv.setTempCritical( Integer.parseInt( editText.getText().toString() ) );
            savePreferences( "tempCritical", editText.getText().toString() );

            editText = myView.findViewById( R.id.battery_warning );
            cv.setBatteryWarning( Integer.parseInt( editText.getText().toString() ) );
            savePreferences( "batteryWarning", editText.getText().toString() );

            editText = myView.findViewById( R.id.battery_critical );
            cv.setBatteryCritical( Integer.parseInt( editText.getText().toString() ) );
            savePreferences( "batteryCritical", editText.getText().toString() );

            editText = myView.findViewById( R.id.voltage_warning );
            cv.setVoltageWarning( Integer.parseInt( editText.getText().toString() ) );
            savePreferences( "voltageWarning", editText.getText().toString() );

            editText = myView.findViewById( R.id.voltage_critical );
            cv.setVoltageCritical( Integer.parseInt( editText.getText().toString() ) );
            savePreferences( "voltageCritical", editText.getText().toString() );

            //works!
            //System.out.println(cv.toString());
            System.out.println("from critical values " + cv.toString());
            Snackbar snackbar = Snackbar.make( myView, "Saved numbers", Snackbar.LENGTH_SHORT );
            snackbar.show();
        }
    };
}


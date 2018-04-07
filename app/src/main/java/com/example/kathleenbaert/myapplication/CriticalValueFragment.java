package com.example.kathleenbaert.myapplication;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
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
    public Context context;
    static CriticalValues cv = new CriticalValues();
    private DrawerLayout drawerLayout;
    public boolean saveTheseValues;

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

    private void savePreferences(String key, int value) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences( context );
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt( key, value );
        editor.commit();
    }

    private void loadSavedPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences( context );
        editText = myView.findViewById( R.id.speed_warning );
        int value = sharedPreferences.getInt( "speedWarning", 0 );
        editText.setText( value + "" );

        editText = myView.findViewById( R.id.speed_critical );
        value = sharedPreferences.getInt( "speedCritical", 0 );
        editText.setText( value + "" );

        editText = myView.findViewById( R.id.temp_warning );
        value = sharedPreferences.getInt( "tempWarning", 0 );
        editText.setText( value + "" );

        editText = myView.findViewById( R.id.temp_critical );
        value = sharedPreferences.getInt( "tempCritical", 0 );
        editText.setText( value + "" );

        editText = myView.findViewById( R.id.battery_warning );
        value = sharedPreferences.getInt( "batteryWarning", 0 );
        editText.setText( value + "" );

        editText = myView.findViewById( R.id.battery_critical );
        value = sharedPreferences.getInt( "batteryCritical", 0 );
        editText.setText( value + "" );

        editText = myView.findViewById( R.id.voltage_warning );
        value = sharedPreferences.getInt( "voltageWarning", 0 );
        editText.setText( value + "" );

        editText = myView.findViewById( R.id.voltage_critical );
        value = sharedPreferences.getInt( "voltageCritical", 0 );
        editText.setText( value + "" );
    }

    private Button.OnClickListener get_edit_view_button_listener = new Button.OnClickListener() {
        public void onClick(View v) {
            saveTheseValues = true;
            //parse out the ints
            int speedWarning = 0, speedCritical = 0, tempWarning = 0, tempCritical = 0, batteryWarning = 0, batteryCritical = 0, voltageWarning = 0, voltageCritical = 0;
            try {
                editText = myView.findViewById( R.id.speed_warning );
                speedWarning = Integer.parseInt( editText.getText().toString() );

                editText = myView.findViewById( R.id.speed_critical );
                speedCritical = Integer.parseInt( editText.getText().toString() );

                editText = myView.findViewById( R.id.temp_warning );
                tempWarning = Integer.parseInt( editText.getText().toString() );

                editText = myView.findViewById( R.id.temp_critical );
                tempCritical = Integer.parseInt( editText.getText().toString() );

                editText = myView.findViewById( R.id.battery_warning );
                batteryWarning = Integer.parseInt( editText.getText().toString() );

                editText = myView.findViewById( R.id.battery_critical );
                batteryCritical = Integer.parseInt( editText.getText().toString() );

                editText = myView.findViewById( R.id.voltage_warning );
                voltageWarning = Integer.parseInt( editText.getText().toString() );

                editText = myView.findViewById( R.id.voltage_critical );
                voltageCritical = Integer.parseInt( editText.getText().toString() );

            } catch (NumberFormatException e) {
                alertBuilder( "Number Format Exception", "Please ensure you entered all 8 values, and there are no negatives or decimal numbers." );
                saveTheseValues = false;
            }

            //set all the critical values
            try {
                cv.setSpeedWarning( speedWarning );
                cv.setSpeedCritical( speedCritical );
                cv.setTempWarning( tempWarning );
                cv.setTempCritical( tempCritical );
                cv.setBatteryWarning( batteryWarning );
                cv.setBatteryCritical( batteryCritical );
                cv.setVoltageWarning( voltageWarning );
                cv.setVoltageCritical( voltageCritical );
            } catch (Exception e) {
                alertBuilder( "Problem occurred", "Problem has occurred while setting the critical values. Error: " + e.toString() );
                saveTheseValues = false;
            }
            //savePreferences
            try {
                savePreferences( "speedWarning", speedWarning );

                savePreferences( "speedCritical", speedCritical );

                savePreferences( "tempWarning", tempWarning );

                savePreferences( "tempCritical", tempCritical );

                savePreferences( "batteryWarning", batteryWarning );

                savePreferences( "batteryCritical", batteryCritical );

                savePreferences( "voltageWarning", voltageWarning );

                savePreferences( "voltageCritical", voltageCritical );
            } catch (Exception e) {
                alertBuilder( "Problem occurred", "Problem has occurred while saving your preferences in SharedPreferences. Error " + e.toString() );
                saveTheseValues = false;
            }
            //data validation
            if (speedWarning > speedCritical || speedWarning == speedCritical) {
                alertBuilder( "Fix Speed Values", "Ensure Speed Critical Value is greater than Speed Warning Value, and they are not the same value." );
                saveTheseValues = false;
            }
            if (tempWarning > tempCritical || tempWarning == tempCritical) {
                alertBuilder( "Fix Temperature Values", "Ensure Temperature Critical Value is greater than Temperature Warning Value, and they are not the same value." );
                saveTheseValues = false;
            }
            if (batteryWarning < batteryCritical || batteryCritical == batteryWarning) {
                alertBuilder( "Fix Battery Values", "Ensure Battery Warning Value is greater than Battery Critical Value, and they are not the same value." );
                saveTheseValues = false;
            }
            if (voltageWarning > voltageCritical || voltageWarning == voltageCritical) {
                alertBuilder( "Fix Voltage Values", "Ensure Voltage Critical Value is greater than Voltage Warning Value, and they are not the same value." );
                saveTheseValues = false;
            }
            if (batteryCritical > 100 || batteryWarning > 100) {
                alertBuilder( "Fix Battery Values", "Ensure Battery Values are less than 100. Remember, this is a percentage." );
                saveTheseValues = false;
            }
            if(speedWarning == 0 || speedCritical == 0 || tempWarning == 0 || tempCritical == 0 || batteryWarning == 0 || batteryCritical == 0 || voltageWarning == 0 || voltageCritical == 0){
                alertBuilder("Zero Value", "Ensure none of the values are 0.");
                saveTheseValues = false;
            }

            if (saveTheseValues) {
                Snackbar snackbar = Snackbar.make( myView, "Saved numbers", Snackbar.LENGTH_SHORT );
                snackbar.show();
            }
        }
    };

    public void alertBuilder(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder( context );
        builder.setMessage( message ).setTitle( title );
        builder.setPositiveButton( "OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

            }
        } );
        AlertDialog dialog = builder.create();
        dialog.show();
    }


}


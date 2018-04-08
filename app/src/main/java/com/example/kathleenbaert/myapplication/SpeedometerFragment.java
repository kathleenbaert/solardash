package com.example.kathleenbaert.myapplication;

import android.app.Activity;
import android.app.Fragment;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by kathleenbaert on 11/1/17.
 */

public class SpeedometerFragment extends Fragment {

    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate( R.layout.speedometer_dash, container, false );

        new speedActivity();
        return myView;
    }
}
class speedActivity extends Activity implements LocationListener {

    // Define a listenerr that responds to location updates
    public void onLocationChanged(Location location) {
        // Called when a new location is found by the network location provider.
        System.out.println("TEST TEST " + location.getSpeed());
    }

    public void onStatusChanged(String provider, int status, Bundle extras) {
    }

    public void onProviderEnabled(String provider) {
    }

    public void onProviderDisabled(String provider) {
    }
}

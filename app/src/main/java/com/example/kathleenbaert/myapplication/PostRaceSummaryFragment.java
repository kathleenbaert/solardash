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



        return myView;
    }

}

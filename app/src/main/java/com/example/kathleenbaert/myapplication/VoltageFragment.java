package com.example.kathleenbaert.myapplication;

import android.app.Activity;
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
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by kathleenbaert on 11/1/17.
 */

public class VoltageFragment extends Fragment {

    View myView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.voltage_dash, container, false);
        return myView;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated( savedInstanceState );

        String[] nameArray = {"VTest1", "VTest2", "VTest3", "VTest4", "VTest5", "VTest6"};

        String[] infoArray = {
                "Vtest sentence 1",
                "Vtest sentence 2",
                "Vtest sentence 3",
                "Vtest sentence 4",
                "Vtest sentence 5",
                "Vtest sentence 6."
        };

        Integer[] imageArray = {R.drawable.good,
                R.drawable.good,
                R.drawable.good,
                R.drawable.warning,
                R.drawable.good,
                R.drawable.critical};

        ListView listView;

        Context context = myView.getContext();
        CustomListAdapter customListAdapter = new CustomListAdapter( (Activity) context, nameArray, infoArray, imageArray );
        listView = (ListView) myView.findViewById( R.id.listView );
        listView.setAdapter( customListAdapter );

    }

}

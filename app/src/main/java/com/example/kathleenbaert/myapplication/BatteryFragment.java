package com.example.kathleenbaert.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by kathleenbaert on 11/1/17.
 */

public class BatteryFragment extends Fragment {

    View myView;
    Handler mHandler;
    int b1 = 0, b2 = 0, b3 = 0, b4 = 0, b5 = 0, b6 = 0;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.battery_dash, container, false);
        return myView;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated( savedInstanceState );



            super.onCreate(savedInstanceState);
                this.mHandler = new Handler();
                m_Runnable.run();

        }

    public final Runnable m_Runnable = new Runnable()
    {
        public void run()

        {
            b1++;
            b2++;
            b3++;
            b4++;
            b5++;
            b6++;
            BatteryFragment.this.mHandler.postDelayed(m_Runnable,1000);
            String[] nameArray = {"Rear Right", "Rear Middle", "Rear Left", "Front Right", "Front Middle", "Front Left"};

            String[] infoArray = {
                    "Current Battery percentage: " + b1,
                    "Current Battery percentage: " + b2,
                    "Current Battery percentage: " + b3,
                    "Current Battery percentage: " + b4,
                    "Current Battery percentage: " + b5,
                    "Current Battery percentage: " + b6
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

    };


}

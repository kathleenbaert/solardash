package com.example.kathleenbaert.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by kathleenbaert on 11/1/17.
 */

public class BatteryFragment extends Fragment {

    View myView;
    Handler mHandler;
    String[] nameArray;
    static CriticalValues cv = new CriticalValues();
    int [] b = new int [6];
    Random random = new Random();
    static int warning;
    static int critical;

    Integer[] imageArray = new Integer[6];
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.battery_dash, container, false);
        for(int i = 0; i < b.length; i++){
            b[i] = 100;
        }
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

            for(int i = 0; i < b.length; i++){
                b[i]-=random.nextInt( 10 );

            }
            BatteryFragment.this.mHandler.postDelayed(m_Runnable,1000);
            nameArray = new String[]{"Rear Right", "Rear Middle", "Rear Left", "Front Right", "Front Middle", "Front Left"};

            String[] infoArray = {
                    "Current Battery percentage: " + b[0],
                    "Current Battery percentage: " + b[1],
                    "Current Battery percentage: " + b[2],
                    "Current Battery percentage: " + b[3],
                    "Current Battery percentage: " + b[4],
                    "Current Battery percentage: " + b[5]
            };



            ListView listView;

            Context context = myView.getContext();
            CustomListAdapter customListAdapter = new CustomListAdapter( (Activity) context, nameArray, infoArray, imageArray );
            listView = (ListView) myView.findViewById( R.id.listView );
            listView.setAdapter( customListAdapter );
            generateImages();
        }

    };

    public void generateImages(){
        //System.out.println("from battery " + cv.toString());

        warning = 60;
        critical = 30;
        for(int i = 0; i < imageArray.length; i++){
            if(b[i] <= critical){
                imageArray[i] = R.drawable.critical;
                Snackbar snackbar = Snackbar.make( myView, "CRITICAL ALERT ON BATTERY: " + nameArray[i], Snackbar.LENGTH_SHORT );
                snackbar.show();
            }else if(b[i] <=warning){
                imageArray[i] = R.drawable.warning;
            }else{
                imageArray[i] = R.drawable.good;
            }

        }

    }


}

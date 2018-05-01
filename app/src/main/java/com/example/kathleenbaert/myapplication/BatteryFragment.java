
package com.example.kathleenbaert.myapplication;

import android.app.Activity;
import android.app.Fragment;
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

import java.util.Random;

/**
 * Created by kathleenbaert on 11/1/17.
 */

public class BatteryFragment extends Fragment {

    View myView;
    Handler mHandler;
    public static JSONData jsonData = JSONData.jsonData;
    public AlertBuilder ab = new AlertBuilder();
    Random random = new Random();
    static int warning, critical;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.battery_dash, container, false);


        Button button = (Button) myView.findViewById( R.id.button );
        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GraphAccessorsMutators graphAccessorsMutators = GraphAccessorsMutators.graphAccessorsMutators;
                graphAccessorsMutators.setName( "Battery Readings" );
                graphAccessorsMutators.setArrayLists( jsonData.getBatteryHistorical() );
                graphAccessorsMutators.setxLabel( " mins" );
                graphAccessorsMutators.setyLabel( "%" );
                graphAccessorsMutators.setNumOfSensors( jsonData.getBatterySize() );
                graphAccessorsMutators.setNameArrayList( jsonData.getBatteryNameArray() );
                Intent intent = new Intent( getActivity(), GraphLayout.class );
                startActivity( intent );
            }
        } );

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
            BatteryFragment.this.mHandler.postDelayed(m_Runnable,1000);
            String [] nameArray = new String[jsonData.getBatterySize()];
            for(int i = 0; i < jsonData.getBatterySize(); i++){
                nameArray[i] = jsonData.getBatteryNameArray().get( i );
            }
            //set up the infoArray from current data
            String [] infoArray = new String[jsonData.getBatterySize()];
            for(int i = 0; i < jsonData.getBatterySize(); i++){
                infoArray[i] = ("Current Battery Reading: " + jsonData.getCurrBattery().get( i ).toString() + "%");
            }
            ListView listView;
            Integer[] imageArray = generateImages(jsonData.getBatterySize());

            Context context = myView.getContext();
            CustomListAdapter customListAdapter = new CustomListAdapter( (Activity) context, nameArray, infoArray, imageArray );
            listView = (ListView) myView.findViewById( R.id.listView );
            listView.setAdapter( customListAdapter );
        }

    };

    public Integer [] generateImages(int n){
        Integer [] imageArray = new Integer[n];
        warning = CriticalValues.cv.getBatteryWarning();
        critical = CriticalValues.cv.getBatteryCritical();
        for(int i = 0; i < n; i++){
            if(jsonData.currBattery.get( i ) <= critical){
                imageArray[i] = R.drawable.critical;
                if(!jsonData.getBatteryCritical( i )){
                    ab.alertBuilder( "CRITICAL BATTERY ISSUE", "Critical Alert on Battery: " + jsonData.batteryNameArray.get( i ), myView.getContext() );
                    jsonData.setBatteryCritical( true, i );
                }
            }else if(jsonData.currBattery.get( i ) <= warning){
                imageArray[i] = R.drawable.warning;
                if(!jsonData.getBatteryWarning( i )){
                    ab.alertBuilder( "Battery Warning", "Warning on Battery: " + jsonData.batteryNameArray.get( i ), myView.getContext());
                    jsonData.setBatteryWarning( true, i );
                }
            }else{
                imageArray[i] = R.drawable.good;
            }

        }
        return imageArray;

    }


}
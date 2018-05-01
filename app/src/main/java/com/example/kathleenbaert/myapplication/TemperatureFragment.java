package com.example.kathleenbaert.myapplication;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ListView;

/**
 * Created by kathleenbaert on 11/1/17.
 */
public class TemperatureFragment extends Fragment {

    View myView;
    public static JSONData jsonData = JSONData.jsonData;
    Handler mHandler;
    static int warning, critical;
    public AlertBuilder ab = new AlertBuilder();

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate( R.layout.temperature_dash, container, false );

        Button button = (Button) myView.findViewById( R.id.button );
        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GraphAccessorsMutators graphAccessorsMutators = GraphAccessorsMutators.graphAccessorsMutators;
                graphAccessorsMutators.setName( "Temperature Readings" );
                graphAccessorsMutators.setArrayLists( jsonData.getTempHistorical() );
                graphAccessorsMutators.setxLabel( " mins" );
                graphAccessorsMutators.setyLabel( "°" );
                graphAccessorsMutators.setNumOfSensors( jsonData.getTempSize() );
                graphAccessorsMutators.setNameArrayList( jsonData.getTempNameArray() );
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
            TemperatureFragment.this.mHandler.postDelayed(m_Runnable,1000);
            String [] nameArray = new String[jsonData.getTempSize()];
            for(int i = 0; i < jsonData.getTempSize(); i++){
                nameArray[i] = jsonData.getTempNameArray().get( i );
            }
            //set up the infoArray from current data
            String [] infoArray = new String[jsonData.getTempSize()];
            for(int i = 0; i < jsonData.getTempSize(); i++){
                infoArray[i] = ("Current Temperature Reading: " + jsonData.getTempCurr().get( i ).toString() + "°");
            }
            ListView listView;
            Integer[] imageArray = generateImages(jsonData.getTempSize());

            Context context = myView.getContext();
            CustomListAdapter customListAdapter = new CustomListAdapter( (Activity) context, nameArray, infoArray, imageArray );
            listView = (ListView) myView.findViewById( R.id.listView );
            listView.setAdapter( customListAdapter );
        }

    };

    public Integer [] generateImages(int n){
        Integer [] imageArray = new Integer[n];
        warning = CriticalValues.cv.getTempWarning();
        critical = CriticalValues.cv.getTempCritical();
        for(int i = 0; i < n; i++){
            if(jsonData.currTemp.get( i ) >= critical){
                if (!jsonData.getTempCritical( i )) {
                    ab.alertBuilder( "CRITICAL TEMPERATURE ISSUE", "Critical Alert on temperature sensor: " + jsonData.getTempNameArray().get( i ), myView.getContext() );
                    jsonData.setTempCritical( true, i );
                }
                imageArray[i] = R.drawable.critical;
            }else if(jsonData.currTemp.get( i ) >= warning){
                if (!jsonData.getTempWarning( i )) {
                    ab.alertBuilder( "Temperature Warning", "Warning Alert on temperature sensor: " + jsonData.getTempNameArray().get( i ), myView.getContext() );
                    jsonData.setTempCritical( true, i );
                }
                imageArray[i] = R.drawable.warning;
            }else{
                imageArray[i] = R.drawable.good;
            }

        }
        return imageArray;

    }

}
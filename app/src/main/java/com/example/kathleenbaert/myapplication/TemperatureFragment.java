package com.example.kathleenbaert.myapplication;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.ListView;

/**
 * Created by kathleenbaert on 11/1/17.
 */
public class TemperatureFragment extends Fragment {

    View myView;
    JSONData d;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate( R.layout.temperature_dash, container, false );

        return myView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated( savedInstanceState );

        String[] nameArray = {"Octopus", "Pig", "Sheep", "Rabbit", "Snake", "Spider"};

        String[] infoArray = {
                "8 tentacled monster",
                "Delicious in rolls",
                "Great for jumpers",
                "Nice in a stew",
                "Great for shoes",
                "Scary."
        };

        Integer[] imageArray = {R.drawable.good,
                R.drawable.warning,
                R.drawable.critical,
                R.drawable.good,
                R.drawable.warning,
                R.drawable.critical};

        ListView listView;

        Context context = myView.getContext();
        CustomListAdapter customListAdapter = new CustomListAdapter( (Activity) context, nameArray, infoArray, imageArray );
        listView = (ListView) myView.findViewById( R.id.listView );
        listView.setAdapter( customListAdapter );

    }

}

package com.example.kathleenbaert.myapplication;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by kathleenbaert on 11/1/17.
 */

public class RaceGraphsFragment extends Fragment {

    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.race_graphs, container, false);
        myView.getId();
        setUpList();
        return myView;
    }

    public void setUpList(){

        String [] batteryNames = new String [] {"test1", "test2", "test3"};




        ListView listView;

        Context context = myView.getContext();
        GraphListAdapter graphListAdapter = new GraphListAdapter( (Activity) context, batteryNames );
        listView = (ListView) myView.findViewById( R.id.listView );
        listView.setAdapter( graphListAdapter );

    }
}

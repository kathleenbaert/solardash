package com.example.kathleenbaert.myapplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by kathleenbaert on 4/19/18.
 */

public class GraphListAdapter extends ArrayAdapter{

    //to reference the Activity
    private final Activity context;

    //to store the array of battery names
    private final String[] batteryNames;

    private final RaceGraphsFragment rgf = new RaceGraphsFragment();


    public GraphListAdapter(Activity context, String [] batteryNames) {

        super( context, R.layout.race_graphs, batteryNames );

        this.context = context;
        this.batteryNames = batteryNames;
    }
    public View getView(final int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate( R.layout.checkbox_list_row, null, true );

        //this code gets references to objects in the checkbox_list_row.xml file
        CheckBox checkbox = (CheckBox) rowView.findViewById( R.id.checkbox );

        //this code sets the values of the objects to values from the arrays
        checkbox.setText(batteryNames[position]);
        return rowView;

    }

    ;

}

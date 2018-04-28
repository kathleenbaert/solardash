package com.example.kathleenbaert.myapplication;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by kathleenbaert on 3/2/18.
 */

public class CustomListAdapter extends ArrayAdapter {

    //to reference the Activity
    private final Activity context;

    //to store the images
    private final Integer[] imageIDarray;

    //to store the list of names
    private final String[] nameArray;

    //to store the list of info
    private final String[] infoArray;
    private final BatteryFragment bf = new BatteryFragment();

    public CustomListAdapter(Activity context, String[] nameArrayParam, String[] infoArrayParam, Integer[] imageIDArrayParam) {

        super( context, R.layout.listview_row, nameArrayParam );

        this.context = context;
        this.imageIDarray = imageIDArrayParam;
        this.nameArray = nameArrayParam;
        this.infoArray = infoArrayParam;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate( R.layout.listview_row, null, true );

        //this code gets references to objects in the listview_row.xml file
        TextView nameTextField = (TextView) rowView.findViewById( R.id.textViewName );
        TextView infoTextField = (TextView) rowView.findViewById( R.id.textViewInfo );
        ImageView imageView = (ImageView) rowView.findViewById( R.id.imageView );

        //this code sets the values of the objects to values from the arrays
        nameTextField.setText( nameArray[position] );
        infoTextField.setText( infoArray[position] );
        imageView.setImageResource( imageIDarray[position] );

        return rowView;

    }

    ;
}
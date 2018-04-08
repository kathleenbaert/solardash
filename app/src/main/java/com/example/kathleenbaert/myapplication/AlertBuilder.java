package com.example.kathleenbaert.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by kathleenbaert on 4/8/18.
 */

public class AlertBuilder {

    public void alertBuilder(String title, String message, Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder( context );
        builder.setMessage( message ).setTitle( title );
        builder.setPositiveButton( "OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

            }
        } );
        AlertDialog dialog = builder.create();
        dialog.show();
    }



}

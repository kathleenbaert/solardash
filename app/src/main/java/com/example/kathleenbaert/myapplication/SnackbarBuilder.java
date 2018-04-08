package com.example.kathleenbaert.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by kathleenbaert on 4/8/18.
 */

public class SnackbarBuilder {

    public void snackbarBuilder(View myView, String message) {
        Snackbar snackbar = Snackbar.make( myView.getRootView(), message, Snackbar.LENGTH_SHORT );
        snackbar.show();

    }




}

package com.example.kathleenbaert.myapplication;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by kathleenbaert on 11/29/17.
 */

public class JSONData {
    public static JSONData jsonData = new JSONData();

    static String TAG = "JSONData";
    public static double tempF, voltage, amps;

    public static void setTempF(double temp){
        tempF = temp;
    }

    public static double getTempF(){
        return tempF;
    }

    public static void setVoltage(double volt){
        voltage = volt;
    }

    public static double getVoltage(){
        return voltage;
    }

    public static void setAmps(double amp){
        amps = amp;
    }

    public static double getAmps(){
        return amps;
    }

}



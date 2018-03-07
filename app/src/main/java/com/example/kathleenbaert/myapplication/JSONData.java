package com.example.kathleenbaert.myapplication;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by kathleenbaert on 11/29/17.
 */

public class JSONData {
    public static JSONData dataInstance = new JSONData();
    static String TAG = "JSONData";
    public static double tempF;
    public static double tempC;
    public static double voltage;
    public static double amps;

    public static void setTempF(double temp){
        tempF = temp;
    }

    public static double getTempF(){
        return tempF;
    }

    public static void setTempC(double temp){
        tempC = temp;
    }

    public static double getTempC(){
        return tempC;
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
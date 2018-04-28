package com.example.kathleenbaert.myapplication;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by kathleenbaert on 11/29/17.
 */

public class JSONData {
    public static JSONData jsonData = new JSONData();


    static String TAG = "JSONData";
    public static double speedMPH;
    public static ArrayList<Double> currTemp, currVolt, currAmp, speedHistorical;
    public static ArrayList<ArrayList<Double>> tempHistorical, voltageHistorical, ampHistorical;
    public static ArrayList<String> tempNameArray, voltageNameArray, ampNameArray;


    public static void initialize(){
        currTemp = new ArrayList<Double>();
        currVolt = new ArrayList<Double>();
        currAmp = new ArrayList<Double>();
        speedHistorical = new ArrayList<Double>();
        tempHistorical = new ArrayList<ArrayList<Double>> ();
        voltageHistorical = new ArrayList<ArrayList<Double>> ();
        ampHistorical = new ArrayList<ArrayList<Double>> ();
        tempNameArray = new ArrayList<String> ();
        voltageNameArray = new ArrayList<String>();
        ampNameArray = new ArrayList<String>( );
    }

    public static void setSpeed(double speed) {
        speedMPH = speed;
        speedHistorical.add( speed );
    }

    public static double getSpeedCurr() {
        return speedMPH;
    }

    public static ArrayList<Double> getSpeedHistorical() {
        return speedHistorical;
    }

    public static void setTemp(double[] temp) {
        for (int i = 0; i < temp.length; i++) {
            currTemp.add( temp[i] );
            tempHistorical.get( i ).add( temp[i] );
        }
    }
    public static ArrayList<Double> getTempCurr() {
        return currTemp;
    }

    public static ArrayList<ArrayList<Double>> getTempHistorical() {
        return tempHistorical;
    }

    public static void setTempArrayName(String[] names) {
        for (int i = 0; i < names.length; i++) {
            tempNameArray.add( names[i] );
        }
    }

    public static ArrayList<String> getTempNameArray() {
        return tempNameArray;
    }

    public static void setVoltage(double [] volt) {
        for (int i = 0; i < volt.length; i++) {
            currVolt.add( volt[i] );
            voltageHistorical.get( i ).add( volt[i] );
        }
    }

    public static ArrayList<Double> getVoltageCurr() {
        return currVolt;
    }

    public static ArrayList<ArrayList<Double>> getVoltageHistorical() {
        return voltageHistorical;
    }

    public static void setVoltageNameArray(String[] names){
        for (int i = 0; i < names.length; i++) {
            voltageNameArray.add( names[i] );
        }
    }
    public static ArrayList<String> getVoltageNameArray() {
        return voltageNameArray;
    }

    public static void setCurrAmp(double [] amps) {
        for (int i = 0; i < amps.length; i++) {
            currAmp.add( amps[i] );
            ampHistorical.get( i ).add( amps[i] );
        }
    }

    public static ArrayList<Double> getCurrAmps() {
        return currAmp;
    }

    public static ArrayList<ArrayList<Double>> getAmpHistorical() {
        return ampHistorical;
    }

    public static void setAmpNameArray(String[] names){
        for (int i = 0; i < names.length; i++) {
            ampNameArray.add( names[i] );
        }
    }
    public static ArrayList<String> getAmpNameArray() {
        return ampNameArray;
    }
}



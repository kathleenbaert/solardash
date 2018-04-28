package com.example.kathleenbaert.myapplication;

import java.util.ArrayList;

/**
 * Created by kathleenbaert on 11/29/17.
 */

public class JSONData {
    public static JSONData jsonData = new JSONData();

    public static int batterySize;
    static String TAG = "JSONData";
    public static double speedMPH;
    public static ArrayList<Double> currTemp, currVolt, currBattery, speedHistorical;
    public static ArrayList<ArrayList<Double>> tempHistorical, voltageHistorical, batteryHistorical;
    public static ArrayList<String> tempNameArray, voltageNameArray, batteryNameArray;


    public static void initialize(){
        currTemp = new ArrayList<Double>();
        currVolt = new ArrayList<Double>();
        currBattery = new ArrayList<Double>();
        speedHistorical = new ArrayList<Double>();
        tempHistorical = new ArrayList<ArrayList<Double>> ();
        voltageHistorical = new ArrayList<ArrayList<Double>> ();
        batteryHistorical = new ArrayList<ArrayList<Double>> ();
        tempNameArray = new ArrayList<String> ();
        voltageNameArray = new ArrayList<String>();
        batteryNameArray = new ArrayList<String>( );
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

    public static void setBatterySize(int size){
        batterySize = size;
        for(int i = 0; i < size; i++){
            batteryNameArray.add( " " );
            currBattery.add( 0.0 );
            ArrayList<Double> inner = new ArrayList<Double>( );
            inner.add( 0.0 );
            batteryHistorical.add( inner );
        }
    }
    public static int getBatterySize(){
        return batterySize;
    }

    public static void setCurrBattery(Double [] battery) {
        for (int i = 0; i < battery.length; i++) {
            currBattery.set( i, battery[i] );
            //currBattery.add( battery[i] );
            batteryHistorical.get( i ).add( battery[i] );
        }
    }




    public static ArrayList<Double> getCurrBattery() {
        return currBattery;
    }

    public static ArrayList<ArrayList<Double>> getBatteryHistorical() {
        return batteryHistorical;
    }

    public static void setBatteryNameArray(String[] names){
        for (int i = 0; i < names.length; i++) {
            batteryNameArray.add( names[i] );
        }
    }
    public static ArrayList<String> getBatteryNameArray() {
        return batteryNameArray;
    }
}



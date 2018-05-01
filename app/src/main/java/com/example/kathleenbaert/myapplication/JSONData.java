package com.example.kathleenbaert.myapplication;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by kathleenbaert on 11/29/17.
 */

public class JSONData {
    public static JSONData jsonData = new JSONData();
    static String TAG = "JSONData";

    public static double currSpeed;
    public static int tempSize, batterySize, voltageSize;
    public static ArrayList < String > tempNameArray, batteryNameArray, voltageNameArray;
    public static ArrayList < Double > speedHistorical, currTemp, currBattery, currVoltage;
    public static ArrayList < ArrayList < Double >> tempHistorical, batteryHistorical, voltageHistorical;
    public static boolean speedWarning, speedCritical;
    public static boolean[] tempWarning, tempCritical, batteryWarning, batteryCritical, voltageWarning, voltageCritical;

    public static void initialize() {
        tempNameArray = new ArrayList < String > ();
        batteryNameArray = new ArrayList < String > ();
        voltageNameArray = new ArrayList < String > ();

        currTemp = new ArrayList < Double > ();
        currBattery = new ArrayList < Double > ();
        currVoltage = new ArrayList < Double > ();

        speedHistorical = new ArrayList < Double > ();
        tempHistorical = new ArrayList < ArrayList < Double >> ();
        batteryHistorical = new ArrayList < ArrayList < Double >> ();
        voltageHistorical = new ArrayList < ArrayList < Double >> ();

    }

    public static void setCurrSpeed(double speed) {
        currSpeed = speed;
        speedHistorical.add(speed);
    }
    public static double getSpeedCurr() {
        return currSpeed;
    }
    public static ArrayList < Double > getSpeedHistorical() {
        return speedHistorical;
    }
    public static void setSpeedWarning(boolean b) {
        speedWarning = b;
    }
    public static boolean getSpeedWarning() {
        return speedWarning;
    }
    public static void setSpeedCritical(boolean b) {
        speedCritical = b;
    }
    public static boolean getSpeedCritical() {
        return speedCritical;
    }
    public static void setTempSize(int size) {
        tempSize = size;
        tempWarning = new boolean[size];
        tempCritical = new boolean[size];
        for (int i = 0; i < size; i++) {
            tempNameArray.add(" ");
            currTemp.add(100.0);
            ArrayList < Double > inner = new ArrayList < Double > ();
            inner.add(100.0);
            tempHistorical.add(inner);
            tempWarning[i] = false;
            tempCritical[i] = false;
        }
    }
    public static int getTempSize() {
        return tempSize;
    }

    public static void setTempArrayName(String[] names) {
        for (int i = 0; i < names.length; i++) {
            tempNameArray.add(names[i]);
        }
    }
    public static ArrayList < String > getTempNameArray() {
        return tempNameArray;
    }
    public static void setCurrTemp(Double[] temp) {
        for (int i = 0; i < temp.length; i++) {
            currTemp.set(i, temp[i]);
            tempHistorical.get(i).add(temp[i]);
        }
    }
    public static ArrayList < Double > getTempCurr() {
        return currTemp;
    }
    public static ArrayList < ArrayList < Double >> getTempHistorical() {
        return tempHistorical;
    }
    public static void setTempWarning(boolean b, int i) {
        tempWarning[i] = b;
    }

    public static boolean getTempWarning(int i) {
        return tempWarning[i];
    }
    public static void setTempCritical(boolean b, int i) {
        tempCritical[i] = b;
    }

    public static boolean getTempCritical(int i) {
        return tempCritical[i];
    }

    public static void setBatterySize(int size) {
        batterySize = size;
        batteryWarning = new boolean[size];
        batteryCritical = new boolean[size];

        for (int i = 0; i < size; i++) {
            batteryNameArray.add(" ");
            currBattery.add(100.0);
            ArrayList < Double > inner = new ArrayList < Double > ();
            inner.add(100.0);
            batteryHistorical.add(inner);
            batteryWarning[i] = false;
            batteryCritical[i] = false;
        }
    }
    public static int getBatterySize() {
        return batterySize;
    }

    public static void setBatteryNameArray(String[] names) {
        for (int i = 0; i < names.length; i++) {
            batteryNameArray.add(names[i]);
        }
    }

    public static ArrayList < String > getBatteryNameArray() {
        return batteryNameArray;
    }
    public static void setCurrBattery(Double[] battery) {
        for (int i = 0; i < battery.length; i++) {
            currBattery.set(i, battery[i]);
            batteryHistorical.get(i).add(battery[i]);
        }
    }

    public static ArrayList < Double > getCurrBattery() {
        return currBattery;
    }

    public static ArrayList < ArrayList < Double >> getBatteryHistorical() {
        return batteryHistorical;
    }


    public static void setBatteryWarning(boolean b, int i) {
        batteryWarning[i] = b;
    }

    public static boolean getBatteryWarning(int i) {
        return batteryWarning[i];
    }
    public static void setBatteryCritical(boolean b, int i) {
        batteryCritical[i] = b;
    }

    public static boolean getBatteryCritical(int i) {
        return batteryCritical[i];
    }


    public static void setVoltageSize(int size) {
        voltageSize = size;
        voltageWarning = new boolean[size];
        voltageCritical = new boolean[size];
        for (int i = 0; i < size; i++) {
            voltageNameArray.add(" ");
            currVoltage.add(25.0);
            ArrayList < Double > inner = new ArrayList < Double > ();
            inner.add(21.0);
            voltageHistorical.add(inner);
            voltageWarning[i] = false;
            voltageCritical[i] = false;
        }
    }

    public static int getVoltageSize() {
        return voltageSize;
    }

    public static void setVoltageNameArray(String[] names) {
        for (int i = 0; i < names.length; i++) {
            voltageNameArray.add(names[i]);
        }
    }

    public static ArrayList < String > getVoltageNameArray() {
        return voltageNameArray;
    }


    public static void setCurrVoltage(Double[] volt) {
        for (int i = 0; i < volt.length; i++) {
            currVoltage.set(i, volt[i]);
            voltageHistorical.get(i).add(volt[i]);
        }
    }

    public static ArrayList < Double > getVoltageCurr() {
        return currVoltage;
    }

    public static ArrayList < ArrayList < Double >> getVoltageHistorical() {
        return voltageHistorical;
    }

    public static void setVoltageWarning(boolean b, int i) {
        voltageWarning[i] = b;
    }

    public static boolean getVoltageWarning(int i) {
        return voltageWarning[i];
    }

    public static void setVoltageCritical(boolean b, int i) {
        voltageCritical[i] = b;
    }

    public static boolean getVoltageCritical(int i) {
        return voltageCritical[i];
    }

}
package com.example.kathleenbaert.myapplication;

/**
 * Created by kathleenbaert on 3/4/18.
 */

public class CriticalValues {

    int speedWarning, speedCritical;
    int tempWarning, tempCritical;
    int batteryWarning, batteryCritical;
    int voltageWarning, voltageCritical;

    public int getSpeedWarning() {
        return speedWarning;
    }

    public int getSpeedCritical() {
        return speedCritical;
    }

    public int getTempWarning() {
        return tempWarning;
    }

    public int getTempCritical() {
        return tempCritical;
    }

    public int getBatteryWarning() {
        return batteryWarning;
    }

    public int getBatteryCritical() {
        return batteryCritical;
    }

    public int getVoltageWarning() {
        return voltageWarning;
    }

    public int getVoltageCritical() {
        return voltageCritical;
    }

    public void setSpeedWarning(int speedWarning) {
        this.speedWarning = speedWarning;
    }

    public void setSpeedCritical(int speedCritical) {
        this.speedCritical = speedCritical;
    }

    public void setTempWarning(int tempWarning) {
        this.tempWarning = tempWarning;
    }

    public void setTempCritical(int tempCritical) {
        this.tempCritical = tempCritical;
    }

    public void setBatteryWarning(int batteryWarning) {
        this.batteryWarning = batteryWarning;
    }

    public void setBatteryCritical(int batteryCritical) {
        this.batteryCritical = batteryCritical;
    }

    public void setVoltageWarning(int voltageWarning) {
        this.voltageWarning = voltageWarning;
    }

    public void setVoltageCritical(int voltageCritical) {
        this.voltageCritical = voltageCritical;
    }
    public String toString(){
        String s = "";
        s += "speed warning: " + speedWarning;
        s += "\nspeed critical: " + speedCritical;
        s += "\ntemp warning: " + tempWarning;
        s += "\ntemp critical: " + tempCritical;
        s += "\nbattery warning: " + batteryWarning;
        s += "\nbattery critical: " + batteryCritical;
        s += "\nvoltage warning: " + voltageWarning;
        s += "\nvoltage critical: " + voltageCritical;
        return s;
    }
}

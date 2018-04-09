package com.example.kathleenbaert.myapplication;

/**
 * Created by kathleenbaert on 4/8/18.
 */

public class ArrayAccessors {
    public static ArrayAccessors arrayAccessors = new ArrayAccessors();
    //x value will be however many sensors are hooked up, as determined by how much JSON data values are coming in
    //for testing, let's use 4
    public static double[][] batteryArray = new double[4][1000];
    private static int[] batteryInt = {0, 0, 0, 0};
    public static int currGraph = 0;

    public static int getCurrGraph() {
        return currGraph;
    }

    public static void setCurrGraph(int currGraph) {
        ArrayAccessors.currGraph = currGraph;
    }

    public static void addToBatteryArray(int array, double value) {
        batteryArray[array][batteryInt[array]] = value;
        batteryInt[array]++;
    }


    public static double[][] getBatteryArray() {
        return batteryArray;
    }

    public static void setBatteryArray(double[][] batteryArray) {
        ArrayAccessors.batteryArray = batteryArray;
    }


}

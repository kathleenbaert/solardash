package com.example.kathleenbaert.myapplication;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by kathleenbaert on 4/28/18.
 */

public class GraphAccessorsMutators {
    public static String name, xLabel, yLabel;
    public static ArrayList<ArrayList<Double>> arrayLists;
    public static GraphAccessorsMutators graphAccessorsMutators = new GraphAccessorsMutators();
    public static int numOfSensors;
    public static String getxLabel() {
        return xLabel;
    }
    public static void setxLabel(String xLabel) {
        GraphAccessorsMutators.xLabel = xLabel;
    }
    public static String getyLabel() {
        return yLabel;
    }
    public static void setyLabel(String yLabel) {
        GraphAccessorsMutators.yLabel = yLabel;
    }
    public static ArrayList<ArrayList<Double>> getArrayLists() {
        return arrayLists;
    }
    public static void setArrayLists(ArrayList<ArrayList<Double>> arrayLists) {
        GraphAccessorsMutators.arrayLists = arrayLists;
    }
    public static String getName(){
        return name;
    }
    public static void setName(String name){
        GraphAccessorsMutators.name = name;
    }
    public static int getNumOfSensors(){
        return numOfSensors;
    }
    public static void setNumOfSensors(int numOfSensors){
        GraphAccessorsMutators.numOfSensors = numOfSensors;
    }
}

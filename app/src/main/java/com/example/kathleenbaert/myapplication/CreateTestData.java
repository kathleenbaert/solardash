package com.example.kathleenbaert.myapplication;
import android.os.Handler;

import java.util.Random;
/**
 * Created by kathleenbaert on 4/27/18.
 */

public class CreateTestData {

    static Random random = new Random();
    static JSONData jsonData = JSONData.jsonData;
    static String TAG = "CreateTestData";
    static Handler mHandler;

    public void start(){
        jsonData.initialize();
        String [] batteryNames = {"Rear Right", "Rear Left", "Front Right", "Front Left"};
        jsonData.setBatteryNameArray( batteryNames );

        this.mHandler = new Handler();
        m_Runnable.run();

    }

    public final Runnable m_Runnable = new Runnable()
    {
        public void run(){
            CreateTestData.this.mHandler.postDelayed(m_Runnable,1000);
            createSpeedData();
            createBatteryData();

        }
    };
    public static void createSpeedData(){
        //random generates numbers between 20 - 40, without ever any sudden jumps
        if(jsonData.getSpeedCurr() == 0.0){
            //means no data there currently
            jsonData.setSpeed( getRandomNumberInRange( 20, 40 ) );
        }else{
            jsonData.setSpeed( jsonData.getSpeedCurr() + getRandomNumberInRange( -2, 2 ));
        }
        if (jsonData.getSpeedCurr() <= 20){
            jsonData.setSpeed( jsonData.getSpeedCurr() + 2 );
        }
        if(jsonData.getSpeedCurr() >= 40){
            jsonData.setSpeed( jsonData.getSpeedCurr() - 2 );
        }
    }
    public static void createTempData(){


    }
    public static void createBatteryData(){
        //creates 4 battery readings
        Double [] builtReadings = new Double [4];
        jsonData.setBatterySize( 4 );
        for(int i = 0; i < 4; i++){
            if(jsonData.getCurrBattery().get( i ) <= 0.0){
                builtReadings[i] = 100.0;
            }
            else{
                builtReadings[i] = jsonData.getCurrBattery().get( i ) - random.nextDouble();
            }
        }
        jsonData.setCurrBattery( builtReadings );
        //create 4 names:

    }
    public static void createVoltageData(){


    }
    private static int getRandomNumberInRange(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }
}

package com.example.kathleenbaert.myapplication;
import android.os.Handler;

import java.text.DecimalFormat;
import java.util.Random;
/**
 * Created by kathleenbaert on 4/27/18.
 */

public class CreateTestData {

    static Random random = new Random();
    static JSONData jsonData = JSONData.jsonData;
    static String TAG = "CreateTestData";
    static Handler mHandler;
    static DecimalFormat df = new DecimalFormat(".###" );


    public void start(){
        jsonData.initialize();
        String [] tempNames = {"Right Front Tire", "Left Front Tire", "Right Rear Tire", "Left Rear Tire", "Right Brake", "Left Brake"};
        String [] batteryNames = {"Rear Right", "Rear Left", "Middle Right", "Middle Left", "Front Right", "Front Left"};
        String [] voltageNames = {"Rear Right", "Rear Left", "Middle Right", "Middle Left", "Front Right", "Front Left"};
        jsonData.setTempArrayName( tempNames );
        jsonData.setBatteryNameArray( batteryNames );
        jsonData.setVoltageNameArray( voltageNames );
        jsonData.setTempSize( 6 );
        jsonData.setBatterySize( 6 );
        jsonData.setVoltageSize(4);
        this.mHandler = new Handler();
        m_Runnable.run();

    }

    public final Runnable m_Runnable = new Runnable()
    {
        public void run(){
            CreateTestData.this.mHandler.postDelayed(m_Runnable,1000);
            createSpeedData();
            createBatteryData();
            createTempData();
            createVoltageData();
        }
    };

    public static void createSpeedData(){
        //random generates numbers between 20 - 40, without ever any sudden jumps
        if(jsonData.getSpeedCurr() == 0.0){
            //means no data there currently
            jsonData.setCurrSpeed( getRandomNumberInRange( 20, 40 ) );
        }else{
            jsonData.setCurrSpeed( jsonData.getSpeedCurr() + getRandomNumberInRange( -3, 3 ));
        }
        if (jsonData.getSpeedCurr() <= 20){
            jsonData.setCurrSpeed( jsonData.getSpeedCurr() + 2 );
        }
        if(jsonData.getSpeedCurr() >= 40){
            jsonData.setCurrSpeed( jsonData.getSpeedCurr() - 2 );
        }
    }

    public static void createTempData(){
        //creates 6 temp readings
        Double [] builtReadings = new Double[6];
        for(int i = 0; i < jsonData.getTempSize(); i++){
            if(jsonData.getTempCurr().get( i ) <= 100){
                builtReadings[i] = 101.0;
            }else if (jsonData.getTempCurr().get( i ) >=200){
                builtReadings[i] = 199.0;
            }else{
                builtReadings[i] = Double.parseDouble( df.format( jsonData.getTempCurr().get( i ) + -1 + (3 - -1) * random.nextDouble()) );
            }
        }
        jsonData.setCurrTemp( builtReadings );
    }

    public static void createBatteryData(){
        //creates 6 battery readings
        Double [] builtReadings = new Double [6];
        for(int i = 0; i < jsonData.getBatterySize(); i++){
            if(jsonData.getCurrBattery().get( i ) <= 0.0){
                builtReadings[i] = 100.0;
            }
            else{
                builtReadings[i] = Double.parseDouble(df.format( jsonData.getCurrBattery().get( i ) - random.nextDouble()));
            }
        }


        jsonData.setCurrBattery( builtReadings );

    }
    public static void createVoltageData(){
        Double [ ] builtReadings = new Double[4];
        for(int i = 0; i < jsonData.getVoltageSize(); i++){
            if(jsonData.getVoltageCurr().get( i ) <= 20.0){
                builtReadings[i] = 21.0;
            }else if(jsonData.getVoltageCurr().get( i ) >= 30){
                builtReadings[i] = 29.0;
            }else{
                builtReadings[i] = Double.parseDouble( df.format( jsonData.getVoltageCurr().get( i ) + -1 + (1 - -1) * random.nextDouble()) );
            }
        }
        jsonData.setCurrVoltage( builtReadings );
    }
    private static int getRandomNumberInRange(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }
}

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
        this.mHandler = new Handler();
        m_Runnable.run();

    }

    public final Runnable m_Runnable = new Runnable()
    {
        public void run(){
            createSpeedData();


            CreateTestData.this.mHandler.postDelayed(m_Runnable,1000);

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


    }
    public static void createVoltageData(){


    }
    private static int getRandomNumberInRange(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }
}

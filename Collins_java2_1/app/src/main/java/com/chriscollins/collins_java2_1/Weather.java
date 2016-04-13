package com.chriscollins.collins_java2_1;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by chriscollins on 4/11/16.
 */
public class Weather {


    final String TAG = "Weather Class";

    private String mName;
    private double mTemp;
    private String mDescription;
    private double mHumidity;
    private double mTemp_min;
    private double mTemp_max;
    private double mZipCode;

    public Weather() {}


    //Class Constructor
    public Weather(String name, Double temp, String description, Double humidity, Double temp_min, Double temp_max, Double zipCode) {
        this.mName = name;
        this.mTemp = temp;
        this.mDescription = description;
        this.mHumidity = humidity;
        this.mTemp_min = temp_min;
        this.mTemp_max = temp_max;
        this.mZipCode = zipCode;
    }

    public Weather(JSONObject weatherData) {
        try{
            mName = weatherData.getString("name");

            JSONArray apiDataArray = weatherData.getJSONArray("weather");
            JSONObject apiData = apiDataArray.getJSONObject(0);
            mDescription = apiData.getString("description");

            apiData = weatherData.getJSONObject("main");
            mTemp = apiData.getDouble("temp");
            mHumidity = apiData.getDouble("humidity");
            mTemp_min = apiData.getDouble("temp_min");
            mTemp_max = apiData.getDouble("temp_max");
        } catch (Exception e) {
            Log.e(TAG, "Error updating display");
            e.printStackTrace();
        }
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public double getTemp() {
        return mTemp;
    }

    public void setTemp(double temp) {
        mTemp = temp;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public double getHumidity() {
        return mHumidity;
    }

    public void setHumidity(double humidity) {
        mHumidity = humidity;
    }

    public double getTemp_min() {
        return mTemp_min;
    }

    public void setTemp_min(double temp_min) {
        mTemp_min = temp_min;
    }

    public double getTemp_max() {
        return mTemp_max;
    }

    public void setTemp_max(double temp_max) {
        mTemp_max = temp_max;
    }

    public double getZipCode() {
        return mZipCode;
    }

//    public void setZipCode(double zipCode) {
//        mZipCode = zipCode;
//    }
}
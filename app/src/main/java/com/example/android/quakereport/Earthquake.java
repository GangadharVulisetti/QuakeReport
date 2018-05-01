package com.example.android.quakereport;

/**
 * Created by swamygangadharpavanvulisetti on 9/7/17.
 */

public class Earthquake {

    private double eMagnitude;
    private String ePlace;
    private long timeInMilliseconds;
    private String Url;

//    private String offset;
//    private String primary;

    public Earthquake(double magnitude, String place, long date, String url) {

        eMagnitude = magnitude;
        ePlace = place;
        timeInMilliseconds = date;
        Url = url;
        //settingLocation();
    }

    // Way of populating Text views of location from Earth Quake class

//    public void settingLocation(){
//        if (ePlace.contains("of")) {
//            String[] parts = ePlace.split("of");
//            offset = parts[0];
//            primary = parts[1];
//        } else {
//            offset = "Near the";
//            primary = ePlace;
//        }
//
//    }
//    public String getOffset(){
//        return offset;
//    }

//    public String getPrimary(){
//        return primary;
//    }

    public double getMagnitude() {
        return eMagnitude;
    }

    public String getPlace() {
        return ePlace;
    }

    public long getDate() {
        return timeInMilliseconds;
    }

    public String getUrl() {
        return Url;
    }

}

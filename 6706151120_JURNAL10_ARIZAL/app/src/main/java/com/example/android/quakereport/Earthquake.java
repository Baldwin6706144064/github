package com.example.android.quakereport;

/**
 * Created by Praktikan on 23/03/2017.
 */

public class Earthquake {
    private String loc;
    private double mag;
    private long date;

    public Earthquake(double mag, String loc, long date) {
        this.mag = mag;
        this.loc = loc;
        this.date = date;
    }

    public double getMag() {
        return mag;
    }

    public String getLoc() {
        return loc;
    }

    public long getDate() {
        return date;
    }
}

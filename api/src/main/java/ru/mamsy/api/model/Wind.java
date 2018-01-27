package ru.mamsy.api.model;

import com.google.gson.annotations.SerializedName;

/**
 * @author Maxim Berezin.
 */
public class Wind {

    @SerializedName("speed")
    private double speed;

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}

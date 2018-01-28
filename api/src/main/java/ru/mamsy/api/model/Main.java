
package ru.mamsy.api.model;

import com.google.gson.annotations.SerializedName;

public class Main {

    @SerializedName("temp")
    private double temp;
    @SerializedName("pressure")
    private double pressure;
    @SerializedName("humidity")
    private int humidity;

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

}

package ru.mamsy.weathersample.data.api.model;

import java.util.List;


/**
 * @author Maxim Berezin.
 */
public class CityWeatherModel {

    private String name;

    private int id;

    private int code;

    private List<WeatherModel> weathers;

    private double temp;

    private double pressure;

    private double humidity;

    private double speed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<WeatherModel> getWeathers() {
        return weathers;
    }

    public void setWeathers(List<WeatherModel> weathers) {
        this.weathers = weathers;
    }

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

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}

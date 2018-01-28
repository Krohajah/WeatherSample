package ru.mamsy.weathersample.data.api.model;

/**
 * @author Maxim Berezin.
 */
public class ForecastsModel {

    /**
     * дата прогноза в формате dd.MM.
     */
    private String forecastDate;
    /**
     * температура.
     */
    private double temp;
    /**
     * атмосферное давление.
     */
    private double pressure;
    /**
     * влажность.
     */
    private int humidity;

    public String getForecastDate() {
        return forecastDate;
    }

    public void setForecastDate(String forecastDate) {
        this.forecastDate = forecastDate;
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

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
}

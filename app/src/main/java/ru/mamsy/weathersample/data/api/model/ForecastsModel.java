package ru.mamsy.weathersample.data.api.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author Maxim Berezin.
 */
public class ForecastsModel implements Parcelable {

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.forecastDate);
        dest.writeDouble(this.temp);
        dest.writeDouble(this.pressure);
        dest.writeInt(this.humidity);
    }

    public ForecastsModel() {
    }

    protected ForecastsModel(Parcel in) {
        this.forecastDate = in.readString();
        this.temp = in.readDouble();
        this.pressure = in.readDouble();
        this.humidity = in.readInt();
    }

    public static final Parcelable.Creator<ForecastsModel> CREATOR = new Parcelable.Creator<ForecastsModel>() {
        @Override
        public ForecastsModel createFromParcel(Parcel source) {
            return new ForecastsModel(source);
        }

        @Override
        public ForecastsModel[] newArray(int size) {
            return new ForecastsModel[size];
        }
    };
}

package ru.mamsy.weathersample.data.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Модель одного города с погодой.
 *
 * @author Maxim Berezin.
 */
public class WeatherDataModel implements Parcelable {

    /**
     * id города.
     */
    private int cityId;
    /**
     * название города.
     */
    private String cityName;
    /**
     * Список прогнозов на неделю.
     */
    private List<ForecastsModel> forecastsModelList;

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<ForecastsModel> getForecastsModelList() {
        return forecastsModelList;
    }

    public void setForecastsModelList(List<ForecastsModel> forecastsModelList) {
        this.forecastsModelList = forecastsModelList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.cityId);
        dest.writeString(this.cityName);
        dest.writeList(this.forecastsModelList);
    }

    public WeatherDataModel() {
    }

    protected WeatherDataModel(Parcel in) {
        this.cityId = in.readInt();
        this.cityName = in.readString();
        this.forecastsModelList = new ArrayList<ForecastsModel>();
        in.readList(this.forecastsModelList, ForecastsModel.class.getClassLoader());
    }

    public static final Parcelable.Creator<WeatherDataModel> CREATOR = new Parcelable.Creator<WeatherDataModel>() {
        @Override
        public WeatherDataModel createFromParcel(Parcel source) {
            return new WeatherDataModel(source);
        }

        @Override
        public WeatherDataModel[] newArray(int size) {
            return new WeatherDataModel[size];
        }
    };
}

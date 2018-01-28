package ru.mamsy.weathersample.data.api.model;

import java.util.List;

/**
 * Модель одного города с погодой.
 *
 * @author Maxim Berezin.
 */
public class WeatherDataModel {

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
}

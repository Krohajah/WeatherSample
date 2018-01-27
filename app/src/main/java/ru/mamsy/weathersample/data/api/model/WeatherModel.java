package ru.mamsy.weathersample.data.api.model;

/**
 * @author Maxim Berezin.
 */
public class WeatherModel {

    private String main;

    private String icon;

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}

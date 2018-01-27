package ru.mamsy.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Maxim Berezin.
 */
public class City {

    @SerializedName("name")
    private String name;

    @SerializedName("weather")
    private List<Weather> weathers;

    @SerializedName("main")
    private Main main;

    @SerializedName("wind")
    private Wind wind;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Weather> getWeathers() {
        return weathers;
    }

    public void setWeathers(List<Weather> weathers) {
        this.weathers = weathers;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }
}

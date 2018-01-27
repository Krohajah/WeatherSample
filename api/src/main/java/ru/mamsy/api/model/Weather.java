package ru.mamsy.api.model;

import com.google.gson.annotations.SerializedName;

/**
 * @author Maxim Berezin.
 */
public class Weather {

    @SerializedName("main")
    private String main;

    @SerializedName("icon")
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

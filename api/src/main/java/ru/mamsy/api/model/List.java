
package ru.mamsy.api.model;

import com.google.gson.annotations.SerializedName;

public class List {

    @SerializedName("dt")
    private long dt;
    @SerializedName("main")
    private Main main;
    @SerializedName("dt_txt")
    private String dtTxt;

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public String getDtTxt() {
        return dtTxt;
    }

    public void setDtTxt(String dtTxt) {
        this.dtTxt = dtTxt;
    }

}

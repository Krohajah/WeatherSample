package ru.mamsy.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author Maxim Berezin.
 */
public class AddCity {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("cod")
    @Expose
    private String cod;
    @SerializedName("count")
    @Expose
    private int count;
    @SerializedName("list")
    @Expose
    private java.util.List<City> list = null;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public java.util.List<City> getList() {
        return list;
    }

    public void setList(java.util.List<City> list) {
        this.list = list;
    }

}

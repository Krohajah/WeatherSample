package ru.mamsy.weathersample.data.api;

/**
 * Обертка для ошибок АПИ
 *
 * @author Maxim Berezin
 */
public class ApiError {

    private String cod;
    private String message;


    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

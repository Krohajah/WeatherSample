package ru.mamsy.weathersample.data.api;

import java.util.List;

/**
 * Обертка для ошибок АПИ
 *
 * @author Maxim Berezin
 */
public class ApiError {

    private int errorCode;
    private String errorText;
    private List<String> errorDetails;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorText() {
        return errorText;
    }

    public void setErrorText(String errorText) {
        this.errorText = errorText;
    }

    public List<String> getErrorDetails() {
        return errorDetails;
    }

    public void setErrorDetails(List<String> errorDetails) {
        this.errorDetails = errorDetails;
    }
}

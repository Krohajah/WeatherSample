package ru.mamsy.weathersample.data.api.result;

/**
 * @author Maxim Berezin
 */
public enum ResultStatus {
    OK,
    UNKNOWN_ERROR,
    NETWORK_ERROR,
    SERVER_ERROR,
    TIMEOUT_ERROR,
    CONNECTION_ERROR
}

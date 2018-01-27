package ru.mamsy.weathersample.data.api.result;


import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import javax.inject.Inject;

import ru.mamsy.weathersample.data.api.ApiException;

/**
 * @author Maxim Berezin
 */
public class ResultStatusConverter {

    @Inject
    public ResultStatusConverter() {
    }

    public ResultStatus fromThrowable(final Throwable throwable) {
        if (throwable instanceof ApiException) {
            return ResultStatus.SERVER_ERROR;
        } else if (throwable instanceof SocketTimeoutException) {
            return ResultStatus.TIMEOUT_ERROR;
        } else if (throwable instanceof ConnectException) {
            return ResultStatus.CONNECTION_ERROR;
        } else if (throwable instanceof UnknownHostException) {
            return ResultStatus.NETWORK_ERROR;
        } else {
            return ResultStatus.UNKNOWN_ERROR;
        }
    }
}

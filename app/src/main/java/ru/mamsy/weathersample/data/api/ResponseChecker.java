package ru.mamsy.weathersample.data.api;

import io.reactivex.Observable;

/**
 * @author Maxim Berezin
 */
public class ResponseChecker {

    public static <V> Observable<V> checkResponse(Response<V> response) {
        if (response.isSuccessful()) {
            return Observable.just(response.getData());
        } else {
            return Observable.error(new ApiException());
        }
    }
}

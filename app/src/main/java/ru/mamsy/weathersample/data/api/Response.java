package ru.mamsy.weathersample.data.api;

/**
 * Ответ из АПИ.
 *
 * @author Maxim Berezin
 */
public class Response<T> {

    private final T data;
    private final ApiError error;
    private final int code;

    Response(T data, ApiError error, int code) {
        this.data = data;
        this.error = error;
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public ApiError getError() {
        return error;
    }

    public int getCode() {
        return code;
    }

    /**
     * Returns true if the code is in [200..300), which means the request was successfully received,
     * understood, and accepted {@link okhttp3.Response#isSuccessful()}
     */
    public boolean isSuccessful() {
        return code >= 200 && code < 300;
    }
}

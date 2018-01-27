package ru.mamsy.api;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import ru.mamsy.api.model.ApiError;

/**
 * Конвертер ошибок API
 *
 * @author Maxim Berezin
 */
public class ApiErrorConverter {

    /**
     * Instance Retrofit
     */
    private final Retrofit retrofit;

    public ApiErrorConverter(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    /**
     * десереализует ошибку
     */
    public ApiError convert(Response response) throws IOException {
        Converter<ResponseBody, ApiError> errorConverter = retrofit.responseBodyConverter(ApiError.class, new Annotation[0]);
        ResponseBody responseBody = response.errorBody();
        if (responseBody == null) {
            return null;
        } else {
            return errorConverter.convert(responseBody);
        }
    }
}

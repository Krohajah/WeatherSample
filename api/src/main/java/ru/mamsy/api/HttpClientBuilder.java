package ru.mamsy.api;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import ru.mamsy.api.inteceptor.ApiKeyInterceptor;

class HttpClientBuilder {

    /**
     * Таймаут на подключение/чтение/запись (в секундах)
     */
    private static final long TIMEOUT = 60;

    public static OkHttpClient build() {
        return new OkHttpClient.Builder()
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor())
                .addInterceptor(new ApiKeyInterceptor())
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                .build();
    }
}

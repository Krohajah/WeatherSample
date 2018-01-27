package ru.mamsy.api;

import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.wiintech.android.utils.android.ApplicationInfo;
import com.wiintech.android.utils.android.DeviceInfo;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Билдер инстанса Retrofit.
 *
 * @author Maxim Berezin
 */
public class RetrofitBuilder {

    /**
     * API URL
     */
    private String baseUrl;

    /**
     * Instance Retrofit
     */
    private Retrofit retrofit;

    public RetrofitBuilder setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    /**
     * Создает клиент ретрофит
     */
    public Retrofit build(ApplicationInfo applicationInfo, DeviceInfo deviceInfo) {

        OkHttpClient client = HttpClientBuilder.build(applicationInfo, deviceInfo);

        GsonBuilder gsonBuilder = new GsonBuilder()
                .setLenient();

        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gsonBuilder.create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit;
    }
}

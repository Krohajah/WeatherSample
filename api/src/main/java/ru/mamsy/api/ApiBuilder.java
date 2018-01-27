package ru.mamsy.api;

import retrofit2.Retrofit;

/**
 * Билдер инстанса API.
 *
 * @author Maxim Berezin
 */
public class ApiBuilder {

    /**
     * Instance Retrofit
     */
    private final Retrofit retrofit;

    public ApiBuilder(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    /**
     * Создает интсанс API
     *
     * @return API instance
     */
    public Api build() {
        return retrofit.create(Api.class);
    }
}

package ru.mamsy.weathersample.data.api;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import ru.mamsy.api.Api;
import ru.mamsy.api.ApiBuilder;
import ru.mamsy.api.ApiErrorConverter;
import ru.mamsy.api.RetrofitBuilder;
import ru.mamsy.weathersample.BuildConfig;

/**
 * DI-модуль для API.
 *
 * @author Maxim Berezin
 */
@Module
public class ApiModule {

    @Provides
    @Singleton
    public ApiWorker apiWorker() {
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();
        retrofitBuilder.setBaseUrl(BuildConfig.API_BASE_URL);
        Retrofit retrofit = retrofitBuilder.build();
        Api api = new ApiBuilder(retrofit).build();
        ApiErrorConverter apiErrorConverter = new ApiErrorConverter(retrofit);
        return new DefaultApiWorker(api, apiErrorConverter);
    }
}

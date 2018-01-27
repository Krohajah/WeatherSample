package ru.mamsy.api;

import android.support.annotation.NonNull;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.mamsy.api.model.City;

/**
 * API interface.
 *
 * @author Maxim Berezin
 */
public interface Api {
    /**
     * Прогноз на 5 дней.
     *
     * @param query Название города, код страны.
     * @return      прогноз на 5 дней.
     */
    @GET("forecast?units=metric&lang=ru")
    Observable<Response<City>> getForecast(
            @NonNull @Query("q") String query
    );
}

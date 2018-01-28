package ru.mamsy.weathersample.data.api;

import io.reactivex.Observable;
import ru.mamsy.weathersample.data.api.model.WeatherDataModel;

/**
 * Класс взаимодействия с АПИ.
 *
 * @author Maxim Berezin
 */
public interface ApiWorker {

    /**
     * Прогноз на 5 дней.
     *
     * @param query Название города, код страны.
     * @return прогноз на 5 дней.
     */
    Observable<Response<WeatherDataModel>> getForecast(
            String query
    );
}

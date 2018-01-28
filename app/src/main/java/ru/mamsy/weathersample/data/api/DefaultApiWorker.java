package ru.mamsy.weathersample.data.api;

import java.io.IOException;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import ru.mamsy.api.Api;
import ru.mamsy.api.ApiErrorConverter;
import ru.mamsy.logger.Logger;
import ru.mamsy.logger.LoggerFactory;
import ru.mamsy.weathersample.data.api.datamapper.ApiErrorMapper;
import ru.mamsy.weathersample.data.api.datamapper.WeatherDataMapper;
import ru.mamsy.weathersample.data.api.model.WeatherDataModel;


/**
 * @author Maxim Berezin
 */
public class DefaultApiWorker implements ApiWorker {
    Logger logger = LoggerFactory.getLogger(DefaultApiWorker.class);

    private final Api api;
    private final ApiErrorConverter apiErrorConverter;
    private final ApiErrorMapper apiErrorMapper;

    public DefaultApiWorker(Api api, ApiErrorConverter apiErrorConverter) {
        this.api = api;
        this.apiErrorConverter = apiErrorConverter;
        this.apiErrorMapper = new ApiErrorMapper();
    }

    @Override
    public Observable<Response<WeatherDataModel>> getForecast(String query) {
        Observable<Response<WeatherDataModel>> observable = api
                .getForecast(query)
                .map(retrofitResponse -> {
                    logger.info(retrofitResponse.message());
                   return convert(retrofitResponse,
                            entity -> new WeatherDataMapper().toModel(entity));
                });
        return observable;
    }

    /**
     * Конвертирует {@link retrofit2.Response} в {@link Response}.
     *
     * @param retrofitResponse   Ответ сервера в формате {@link Retrofit}
     * @param responseBodyMapper Маппер тела успешного ответа
     * @param <M>                Тип локальной сущности
     * @param <E>                Тип сущности сервера
     * @return Ответ сервера в формате {@link Response}
     * @throws IOException В случае ошибки  ковертации
     */
    <M, E> Response<M> convert(retrofit2.Response<E> retrofitResponse, ResponseBodyMapper<M, E> responseBodyMapper) throws IOException {
        if (retrofitResponse.isSuccessful()) {
            M data = responseBodyMapper.map(retrofitResponse.body());
            return new Response<>(data, null, retrofitResponse.code());
        } else {
            ApiError apiError = apiErrorMapper.toModel(apiErrorConverter.convert(retrofitResponse));
            return new Response<>(null, apiError, retrofitResponse.code());
        }
    }

    /**
     * Маппер тела успешного ответа.
     *
     * @param <M> Тип локальной сущности
     * @param <E> Тип сущности сервера
     */
    interface ResponseBodyMapper<M, E> {
        M map(E entity);
    }
}

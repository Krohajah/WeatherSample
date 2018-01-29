package ru.mamsy.weathersample.ui.activity.main;


import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Single;
import ru.mamsy.logger.Logger;
import ru.mamsy.logger.LoggerFactory;
import ru.mamsy.weathersample.data.api.ApiWorker;
import ru.mamsy.weathersample.data.api.ResponseChecker;
import ru.mamsy.weathersample.data.api.model.WeatherDataModel;
import ru.mamsy.weathersample.data.api.result.InteractorResult;
import ru.mamsy.weathersample.data.api.result.ResultStatus;
import ru.mamsy.weathersample.data.api.result.ResultStatusConverter;

/**
 * Загрузчик погодных данных.
 *
 * @author Maxim Berezin.
 */
public class WeatherLoaderInteractor {

    private final Logger logger = LoggerFactory.getLogger(WeatherLoaderInteractor.class);

    private final ApiWorker apiWorker;
    private final ResultStatusConverter resultStatusConverter;

    @Inject
    public WeatherLoaderInteractor(ApiWorker apiWorker, ResultStatusConverter resultStatusConverter) {
        this.apiWorker = apiWorker;
        this.resultStatusConverter = resultStatusConverter;
    }


    public Single<Result> loadForIds(List<Integer> ids) {
        return Observable.fromIterable(ids)
                .flatMap(apiWorker::getForecast)
                .flatMap(ResponseChecker::checkResponse)
                .toList()
                .map(Result::new)
                .onErrorReturn(throwable -> new Result(resultStatusConverter.fromThrowable(throwable)));

    }


    public static class Result extends InteractorResult {

        private final List<WeatherDataModel> weatherDataModels;

        public Result(List<WeatherDataModel> weatherDataModels) {
            super(ResultStatus.OK);
            this.weatherDataModels = weatherDataModels;
        }

        Result(ResultStatus status) {
            super(status);
            this.weatherDataModels = null;
        }

        public List<WeatherDataModel> getWeatherDataModels() {
            return weatherDataModels;
        }
    }
}

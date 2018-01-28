package ru.mamsy.weathersample.data.api.datamapper;

import ru.mamsy.api.model.WeatherData;
import ru.mamsy.utils.converter.BaseDataMapper;
import ru.mamsy.weathersample.data.api.model.WeatherDataModel;

/**
 * Конвертер API City to WeatherDataMapper.
 *
 * @author Maxim Berezin.
 */
public class WeatherDataMapper extends BaseDataMapper<WeatherDataModel, WeatherData> {

    private final ForecastModelMapper forecastModelMapper = new ForecastModelMapper();

    @Override
    protected WeatherData fromModelImpl(WeatherDataModel model) {
        return null;
    }

    @Override
    protected WeatherDataModel toModelImpl(WeatherData entity) {

        WeatherDataModel model = new WeatherDataModel();
        model.setCityId(entity.getCity().getId());
        model.setCityName(entity.getCity().getName());
        model.setForecastsModelList(forecastModelMapper.toModelList(entity.getList()));

        return model;
    }

}

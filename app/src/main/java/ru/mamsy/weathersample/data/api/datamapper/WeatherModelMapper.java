package ru.mamsy.weathersample.data.api.datamapper;

import ru.mamsy.api.model.Weather;
import ru.mamsy.utils.converter.BaseDataMapper;
import ru.mamsy.weathersample.data.api.model.WeatherModel;

/**
 * @author Maxim Berezin.
 */
public class WeatherModelMapper extends BaseDataMapper<WeatherModel, Weather> {
    @Override
    protected Weather fromModelImpl(WeatherModel model) {
        return null;
    }

    @Override
    protected WeatherModel toModelImpl(Weather entity) {
        WeatherModel weatherModel = new WeatherModel();

        weatherModel.setMain(entity.getMain());
        weatherModel.setIcon(entity.getIcon());
        return weatherModel;
    }
}

package ru.mamsy.weathersample.data.api.datamapper;

import ru.mamsy.api.model.City;
import ru.mamsy.utils.converter.BaseDataMapper;
import ru.mamsy.weathersample.data.api.model.CityWeatherModel;

/**
 * Конвертер API City to CityModelMapper.
 *
 * @author Maxim Berezin.
 */
public class CityModelMapper extends BaseDataMapper<CityWeatherModel, City> {

    private final WeatherModelMapper weatherModelMapper = new WeatherModelMapper();

    @Override
    protected City fromModelImpl(CityWeatherModel model) {
        return null;
    }

    @Override
    protected CityWeatherModel toModelImpl(City entity) {

        CityWeatherModel model = new CityWeatherModel();

        model.setWeathers(weatherModelMapper.toModelList(entity.getWeathers()));
        model.setTemp(entity.getMain().getTemp());
        model.setPressure(entity.getMain().getPressure());
        model.setHumidity(entity.getMain().getHumidity());
        model.setSpeed(entity.getWind().getSpeed());
        model.setName(entity.getName());
        model.setCode(entity.getCode());
        model.setId(entity.getId());

        return model;
    }
}

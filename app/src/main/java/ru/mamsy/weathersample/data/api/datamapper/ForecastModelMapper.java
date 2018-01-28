package ru.mamsy.weathersample.data.api.datamapper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import ru.mamsy.utils.converter.BaseDataMapper;
import ru.mamsy.weathersample.data.api.model.ForecastsModel;

/**
 * @author Maxim Berezin.
 */
public class ForecastModelMapper extends BaseDataMapper<ForecastsModel, ru.mamsy.api.model.List> {

    @Override
    protected ru.mamsy.api.model.List fromModelImpl(ForecastsModel model) {
        return null;
    }

    @Override
    protected ForecastsModel toModelImpl(ru.mamsy.api.model.List entity) {

        ForecastsModel forecastsModel = new ForecastsModel();

        Date date = new Date(entity.getDt()*1000L);
        forecastsModel.setForecastDate(convertDate(date));
        forecastsModel.setTemp(entity.getMain().getTemp());
        forecastsModel.setPressure(entity.getMain().getPressure());
        forecastsModel.setHumidity(entity.getMain().getHumidity());

        return forecastsModel;
    }

    private static ThreadLocal<SimpleDateFormat> simpleDateFormatThreadLocal = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM HH:mm", Locale.getDefault());
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+3"));
            return simpleDateFormat;
        }
    };

    private String convertDate(Date date) {
        if (date == null) {
            return null;
        } else {
            return simpleDateFormatThreadLocal.get().format(date);
        }
    }
}

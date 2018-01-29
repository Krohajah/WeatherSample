package ru.mamsy.weathersample.ui.activity.main;


import java.util.List;

import ru.mamsy.weathersample.data.api.model.WeatherDataModel;
import ru.mamsy.weathersample.mvp.BaseContract;

/**
 * @author Maxim Berezin.
 */
public interface MainView extends BaseContract.View {

    void setupPagerAdapter(List<WeatherDataModel> weatherDataModels);
}

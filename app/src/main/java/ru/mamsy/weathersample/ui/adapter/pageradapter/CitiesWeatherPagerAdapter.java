package ru.mamsy.weathersample.ui.adapter.pageradapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import ru.mamsy.weathersample.data.api.model.WeatherDataModel;
import ru.mamsy.weathersample.ui.fragment.CityWeatherFragment;

/**
 * @author Maxim Berezin.
 */
public class CitiesWeatherPagerAdapter extends FragmentPagerAdapter {

    private final List<WeatherDataModel> weatherDataModelList;

    public CitiesWeatherPagerAdapter(FragmentManager fm, List<WeatherDataModel> weatherDataModelList) {
        super(fm);
        this.weatherDataModelList = weatherDataModelList;
    }

    @Override
    public Fragment getItem(int position) {
        return CityWeatherFragment.newInstance(weatherDataModelList.get(position));
    }

    @Override
    public int getCount() {
        return weatherDataModelList.size();
    }
}

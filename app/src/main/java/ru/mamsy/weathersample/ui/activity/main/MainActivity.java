package ru.mamsy.weathersample.ui.activity.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;

import java.util.List;

import javax.inject.Inject;

import ru.mamsy.logger.Logger;
import ru.mamsy.logger.LoggerFactory;
import ru.mamsy.weathersample.R;
import ru.mamsy.weathersample.data.api.ApiWorker;
import ru.mamsy.weathersample.data.api.model.WeatherDataModel;
import ru.mamsy.weathersample.mvp.BaseMVPActivity;
import ru.mamsy.weathersample.ui.activity.base.ActivityModule;
import ru.mamsy.weathersample.ui.activity.base.ToolbarDelegate;
import ru.mamsy.weathersample.ui.adapter.pageradapter.CitiesWeatherPagerAdapter;

/**
 * Sample.
 *
 * @author Maxim Berezin.
 */
public class MainActivity extends BaseMVPActivity<MainView, MainPresenter> implements MainView {

    Logger logger = LoggerFactory.getLogger("givemeweather");
    //region di
    private MainComponent component;
    @Inject
    ToolbarDelegate toolbarDelegate;
    //endregion
    @Inject
    ApiWorker apiWorker;
    // region Views
    private ViewPager viewPager;
    //endregion
    //region Other
    CitiesWeatherPagerAdapter citiesWeatherPagerAdapter;
    //endregion

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        component = DaggerMainComponent.builder().appComponent(getAppComponent()).activityModule(new ActivityModule(this)).build();
        component.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbarDelegate.init();
        toolbarDelegate.setTitle(getString(R.string.main_activity_title));

        viewPager = findViewById(R.id.viewPager);
        presenter.initialize();

    }

    @Override
    protected MainPresenter initPresenter() {
        presenter = component.presenter();
        return presenter;
    }

    @Override
    public void setupPagerAdapter(List<WeatherDataModel> weatherDataModels) {
        citiesWeatherPagerAdapter = new CitiesWeatherPagerAdapter(getSupportFragmentManager(), weatherDataModels);
        viewPager.setAdapter(citiesWeatherPagerAdapter);
    }
}

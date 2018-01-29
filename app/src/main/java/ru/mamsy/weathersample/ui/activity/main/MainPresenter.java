package ru.mamsy.weathersample.ui.activity.main;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.plugins.RxJavaPlugins;
import ru.mamsy.localdb.CityEntity;
import ru.mamsy.localdb.CityRepository;
import ru.mamsy.logger.Logger;
import ru.mamsy.logger.LoggerFactory;
import ru.mamsy.utils.rx.AppSchedulers;
import ru.mamsy.weathersample.data.api.model.WeatherDataModel;
import ru.mamsy.weathersample.mvp.BasePresenter;

/**
 * @author Maxim Berezin.
 */
public class MainPresenter extends BasePresenter<MainView> {

    private final Logger logger = LoggerFactory.getLogger(MainPresenter.class);

    //region DI
    private final Context context;
    private final WeatherLoaderInteractor weatherLoaderInteractor;
    private final CityRepository cityRepository;
    //endregion
    // Common fields start
    private boolean initialized = false;
    private Disposable weatherDisposable = Disposables.disposed();
    // Common fields end
    private List<WeatherDataModel> weatherDataModels;

    @Inject
    public MainPresenter(Context context, WeatherLoaderInteractor weatherLoaderInteractor, CityRepository cityRepository) {
        this.context = context;
        this.weatherLoaderInteractor = weatherLoaderInteractor;
        this.cityRepository = cityRepository;
    }

    void initialize() {
        if (!initialized) {
            initialized = true;
            onInitialize();
        }
    }

    private void onInitialize() {
        requestWeatherData();
    }

    /**
     * Грузит прогноз погоды для списка ИД.
     */
    public void requestWeatherData() {
        weatherDisposable = cityRepository
                .getCiies()
                .flatMapSingle(entities -> {
                    List<Integer> ids = new ArrayList<>();
                    for (CityEntity cityEntity : entities) {
                        ids.add(cityEntity.getId());
                    }
                    return weatherLoaderInteractor.loadForIds(ids);
                })

                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(AppSchedulers.network())
                .subscribe(this::onInteractorComplete,
                        throwable -> RxJavaPlugins.getErrorHandler().accept(throwable));
    }

    private void onInteractorComplete(WeatherLoaderInteractor.Result result) {
        if (result.isOk()) {
            weatherDataModels = result.getWeatherDataModels();
            if (weatherDataModels != null) {
                getView().setupPagerAdapter(weatherDataModels);
            }
        }
    }

}

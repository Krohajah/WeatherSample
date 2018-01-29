package ru.mamsy.weathersample.ui.activity.main;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.plugins.RxJavaPlugins;
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
    //endregion
    // Common fields start
    private boolean initialized = false;
    private Disposable weatherDisposable = Disposables.disposed();
    // Common fields end
    private List<WeatherDataModel> weatherDataModels;

    @Inject
    public MainPresenter(Context context, WeatherLoaderInteractor weatherLoaderInteractor) {
        this.context = context;
        this.weatherLoaderInteractor = weatherLoaderInteractor;
    }

    void initialize() {
        if (!initialized) {
            initialized = true;
            onInitialize();
        }
    }

    private void onInitialize() {

    }

    /**
     * Грузит прогноз погоды для списка ИД.
     */
    public void requestWeatherData() {
        java.util.List<Integer> list = new ArrayList<>();
        list.add(707860);
        list.add(519188);
        list.add(1283378);
        weatherDisposable = weatherLoaderInteractor
                .loadForIds(list)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(AppSchedulers.network())
                .subscribe(this::onInteractorComplete,
                        throwable -> RxJavaPlugins.getErrorHandler().accept(throwable));
    }

    private void onInteractorComplete(WeatherLoaderInteractor.Result result) {
        if (result.isOk()) {
            weatherDataModels = result.getWeatherDataModels();
            logger.trace("weatherDataModels.size() = " + weatherDataModels.size());
//            balanceModel = result.getBalanceModel();
//            if (balanceModel != null) {
//                getView().setDriverBalance(balanceModel.getBalance());
//            } else {
//                getView().setDriverBalance("");
//            }
//        } else {
//            getView().showErrorMsg(context, result.getStatus());
        }
    }

}

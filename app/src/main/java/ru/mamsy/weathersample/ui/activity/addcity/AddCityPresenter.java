package ru.mamsy.weathersample.ui.activity.addcity;


import android.content.Context;
import android.content.res.ColorStateList;
import android.support.v4.content.ContextCompat;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.schedulers.Schedulers;
import ru.mamsy.localdb.CityRepository;
import ru.mamsy.logger.Logger;
import ru.mamsy.logger.LoggerFactory;
import ru.mamsy.weathersample.R;
import ru.mamsy.weathersample.data.api.ApiWorker;
import ru.mamsy.weathersample.data.api.ResponseChecker;
import ru.mamsy.weathersample.mvp.BasePresenter;

/**
 * @author Maxim Berezin.
 */
public class AddCityPresenter extends BasePresenter<AddCityView> {

    Logger logger = LoggerFactory.getLogger(AddCityPresenter.class);

    //region DI
    private final Context context;
    private final CityRepository cityRepository;
    private final ApiWorker apiWorker;
    //endregion
    // Common fields start
    private boolean initialized = false;
    private Disposable addCityDisposable = Disposables.disposed();
    // Common fields end

    @Inject
    public AddCityPresenter(Context context, CityRepository cityRepository, ApiWorker apiWorker) {
        this.context = context;
        this.cityRepository = cityRepository;
        this.apiWorker = apiWorker;
    }

    void initialize() {
        if (!initialized) {
            initialized = true;
            onInitialize();
        }
    }


    private void onInitialize() {

    }

    void onAddCityBtnClicked(String cityName) {
        getView().hideSoftKeyboard();
        if (cityName == null) {
            displayError();
        } else {
            addCityDisposable.dispose();
            addCityDisposable = apiWorker.getCity(cityName)
                    .flatMap(ResponseChecker::checkResponse)
                    .doOnNext(cityRepository::insert)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .doOnSubscribe(disposable ->
                            getView().setLoadingViewVisible(true))
                    .subscribe(result -> getView().navigateToMainActivity(),
                            throwable -> {
                                getView().setLoadingViewVisible(false);
                                displayError();
                            }
                    );
        }

    }

    private void displayError() {
        ColorStateList colorStateList = ColorStateList.valueOf(ContextCompat.getColor(context, R.color.colorError));
        getView().setEditTextUnderlineColor(colorStateList);
        getView().setAuthErrorMsgVisible(true);
    }

    @Override
    public void onPresenterDestroy() {
        super.onPresenterDestroy();
        addCityDisposable.dispose();
    }
}

package ru.mamsy.weathersample.ui.activity.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;

import javax.inject.Inject;

import ru.mamsy.logger.Logger;
import ru.mamsy.logger.LoggerFactory;
import ru.mamsy.weathersample.R;
import ru.mamsy.weathersample.data.api.ApiWorker;
import ru.mamsy.weathersample.data.api.result.InteractorResult;
import ru.mamsy.weathersample.data.api.result.ResultStatus;
import ru.mamsy.weathersample.mvp.BaseMVPActivity;
import ru.mamsy.weathersample.ui.activity.base.ActivityModule;
import ru.mamsy.weathersample.ui.activity.base.ToolbarDelegate;

/**
 * Sample.
 *
 * @author Maxim Berezin.
 */
public class MainActivity extends BaseMVPActivity<MainView, MainPresenter> {

    Logger logger = LoggerFactory.getLogger("givemeweather");
    //region di
    private MainComponent component;
    @Inject
    ToolbarDelegate toolbarDelegate;
    //endregion
    @Inject
    ApiWorker apiWorker;

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
        Button button = findViewById(R.id.button);

        button.setOnClickListener(view -> presenter.requestWeatherData());

    }

    @Override
    protected MainPresenter initPresenter() {
        presenter = component.presenter();
        return presenter;
    }

    public static class Result extends InteractorResult {

        Result() {
            super(ResultStatus.OK);
        }

        Result(ResultStatus status) {
            super(status);
        }

    }
}

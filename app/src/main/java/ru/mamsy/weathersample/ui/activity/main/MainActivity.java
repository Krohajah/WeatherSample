package ru.mamsy.weathersample.ui.activity.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import ru.mamsy.weathersample.R;
import ru.mamsy.weathersample.mvp.BaseMVPActivity;
import ru.mamsy.weathersample.ui.activity.base.ActivityModule;
import ru.mamsy.weathersample.ui.activity.base.ToolbarDelegate;

/**
 * Sample.
 *
 * @author Maxim Berezin.
 */
public class MainActivity extends BaseMVPActivity<MainView, MainPresenter> {

    //region di
    private MainComponent component;
    @Inject
    ToolbarDelegate toolbarDelegate;
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
    }

    @Override
    protected MainPresenter initPresenter() {
        presenter = component.presenter();
        return presenter;
    }
}

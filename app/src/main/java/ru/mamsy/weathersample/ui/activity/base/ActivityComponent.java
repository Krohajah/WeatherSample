package ru.mamsy.weathersample.ui.activity.base;

import android.app.Activity;

import dagger.Component;
import ru.mamsy.weathersample.AppComponent;
import ru.mamsy.weathersample.di.ActivityScope;

/**
 * @author Maxim Berezin.
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = {ActivityModule.class})
public interface ActivityComponent {

    Activity activity();

    ToolbarDelegate toolbarDelegate();

}

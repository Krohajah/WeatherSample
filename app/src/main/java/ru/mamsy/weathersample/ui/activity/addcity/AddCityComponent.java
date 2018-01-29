package ru.mamsy.weathersample.ui.activity.addcity;


import dagger.Component;
import ru.mamsy.weathersample.AppComponent;
import ru.mamsy.weathersample.di.ActivityScope;
import ru.mamsy.weathersample.ui.activity.base.ActivityComponent;
import ru.mamsy.weathersample.ui.activity.base.ActivityModule;

/**
 * @author Maxim Berezin.
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface AddCityComponent extends ActivityComponent {

    AddCityPresenter authPresenter();

    void inject(AddCityActivity addCityActivity);
}

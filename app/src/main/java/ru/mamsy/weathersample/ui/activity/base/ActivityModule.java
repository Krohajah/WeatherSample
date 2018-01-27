package ru.mamsy.weathersample.ui.activity.base;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;
import ru.mamsy.weathersample.di.ActivityScope;

/**
 * @author Maxim Berezin.
 */
@ActivityScope
@Module
public class ActivityModule {

    private final BaseActivity activity;

    public ActivityModule(BaseActivity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    public Activity activity() {
        return activity;
    }

    @Provides
    @ActivityScope
    public BaseActivity baseActivity() {
        return activity;
    }

}

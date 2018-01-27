package ru.mamsy.weathersample;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import ru.mamsy.weathersample.data.api.ApiModule;
import ru.mamsy.weathersample.data.api.ApiWorker;
import ru.mamsy.weathersample.ui.activity.base.ActivityModule;

/**
 * Di приложения.
 *
 * @author Maxim Berezin
 */
@Singleton
@Component(modules = {AppModule.class,ApiModule.class, ActivityModule.class})
//@Component(modules = {AppModule.class, AppDatabaseModule.class, ApiModule.class, ActivityModule.class})
public interface AppComponent {

    App app();

    Context context();

//    AppDatabase appDatabase();
//
    ApiWorker apiWorker();

}

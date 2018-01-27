package ru.mamsy.weathersample;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Di приложения.
 *
 * @author Maxim Berezin
 */
@Singleton
@Component(modules = {AppModule.class})
//@Component(modules = {AppModule.class, AppDatabaseModule.class, ApiModule.class, ActivityModule.class})
public interface AppComponent {

    App app();

    Context context();

//    AppDatabase appDatabase();
//
//    ApiWorker apiWorker();

}

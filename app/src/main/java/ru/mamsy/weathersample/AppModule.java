package ru.mamsy.weathersample;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * DI-модуль для приложения.
 *
 * @author Maxim Berezin.
 */
@Singleton
@Module
public class AppModule {

    private final App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public App app() {
        return app;
    }

    @Provides
    @Singleton
    public Context context() {
        return app;
    }

}

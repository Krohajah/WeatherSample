package ru.mamsy.weathersample;

import android.app.Application;

/**
 * Приложение.
 *
 * @author Maxim Berezin
 */
public class App extends Application {

    private static AppComponent appComponent;

    public static AppComponent appComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initDi();
    }

    private void initDi() {
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }
}

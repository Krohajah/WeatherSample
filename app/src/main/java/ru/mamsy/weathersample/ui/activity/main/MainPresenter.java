package ru.mamsy.weathersample.ui.activity.main;

import android.content.Context;

import javax.inject.Inject;

import ru.mamsy.weathersample.mvp.BasePresenter;

/**
 * @author Maxim Berezin.
 */
public class MainPresenter extends BasePresenter<MainView> {

    //    private final ApiWorker apiWorker;
    private final Context context;

    @Inject
    public MainPresenter(Context context) {
        this.context = context;
    }
//    private final AppDatabase appDatabase;

//    @Inject
//    MainPresenter(ApiWorker apiWorker, Context context, AppDatabase appDatabase) {
//        this.apiWorker = apiWorker;
//        this.context = context;
//        this.appDatabase = appDatabase;
//    }
}

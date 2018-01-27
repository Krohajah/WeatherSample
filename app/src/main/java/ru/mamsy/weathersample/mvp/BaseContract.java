package ru.mamsy.weathersample.mvp;

import android.arch.lifecycle.Lifecycle;
import android.os.Bundle;

/**
 * @author Maxim Berezin.
 */
public interface BaseContract {
    interface View {

    }

    interface Presenter<V extends BaseContract.View> {

        void attachLifecycle(Lifecycle lifecycle);

        void detachLifecycle(Lifecycle lifecycle);

        void attachView(V view);

        void detachView();

        V getView();

        boolean isViewAttached();

        void onPresenterDestroy();

        Bundle getStateBundle();
    }
}

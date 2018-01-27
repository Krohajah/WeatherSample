package ru.mamsy.weathersample.mvp;

import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import ru.mamsy.weathersample.ui.activity.base.BaseActivity;


/**
 * @author Maxim Berezin.
 */
public abstract class BaseMVPActivity<V extends BaseContract.View, P extends BaseContract.Presenter<V>> extends BaseActivity implements BaseContract.View {

    private final LifecycleRegistry lifecycleRegistry =
            new LifecycleRegistry(this);
    protected P presenter;

    @CallSuper
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BaseViewModel<V, P> viewModel = ViewModelProviders.of(this).get(BaseViewModel.class);
        if (viewModel.getPresenter() == null) {
            viewModel.setPresenter(initPresenter());
        }
        presenter = viewModel.getPresenter();
        presenter.attachLifecycle(getLifecycle());
        presenter.attachView((V) this);
    }

    @NonNull
    @Override
    public LifecycleRegistry getLifecycle() {
        return lifecycleRegistry;
    }

    @CallSuper
    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachLifecycle(getLifecycle());
        presenter.detachView();
    }

    protected abstract P initPresenter();
}

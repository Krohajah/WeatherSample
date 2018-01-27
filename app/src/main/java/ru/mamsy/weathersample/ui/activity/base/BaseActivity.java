package ru.mamsy.weathersample.ui.activity.base;

import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import ru.mamsy.weathersample.App;
import ru.mamsy.weathersample.AppComponent;
import ru.mamsy.weathersample.R;


/**
 * @author Maxim Berezin.
 */
public class BaseActivity extends AppCompatActivity {

    protected final AppComponent getAppComponent() {
        return App.appComponent();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawableResource(getBackgroundDrawableResource());
    }

    @ColorRes
    protected int getBackgroundDrawableResource() {
        return R.color.colorBG;
    }

}

package ru.mamsy.weathersample.ui.activity.base;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import ru.mamsy.weathersample.R;
import ru.mamsy.weathersample.di.ActivityScope;

/**
 * Делегат для обработки тулбара.
 *
 * @author Maxim Berezin.
 */
@ActivityScope
public class ToolbarDelegate {

    private final BaseActivity activity;
    private TextView customTitle;
    private Toolbar toolbar;

    @Inject
    public ToolbarDelegate(BaseActivity activity) {
        this.activity = activity;
    }

    public void init() {
        toolbar = activity.findViewById(R.id.toolbar);
        customTitle = toolbar.findViewById(R.id.customTitle);
        activity.setSupportActionBar(toolbar);
    }

    public void setTitle(@StringRes int resId) {
        customTitle.setText(resId);
    }

    public void setTitle(CharSequence title) {
        customTitle.setText(title);
    }

    public void setNavigationIcon(@DrawableRes int resId) {
        toolbar.setNavigationIcon(resId);
    }

    public void setNavigationOnClickListener(View.OnClickListener listener) {
        toolbar.setNavigationOnClickListener(listener);
    }
}

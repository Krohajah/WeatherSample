package ru.mamsy.weathersample.ui.activity.addcity;

import android.content.res.ColorStateList;

import ru.mamsy.weathersample.mvp.BaseContract;


/**
 * @author Maxim Berezin.
 */
public interface AddCityView extends BaseContract.View {

    void setAuthErrorMsgVisible(boolean visible);

    void setEditTextUnderlineColor(ColorStateList colorStateList);

    void navigateToMainActivity();

    void hideSoftKeyboard();

    void setLoadingViewVisible(boolean visible);
}

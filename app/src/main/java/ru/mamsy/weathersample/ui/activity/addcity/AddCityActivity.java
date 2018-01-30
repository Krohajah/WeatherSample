package ru.mamsy.weathersample.ui.activity.addcity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import ru.mamsy.weathersample.R;
import ru.mamsy.weathersample.mvp.BaseMVPActivity;
import ru.mamsy.weathersample.ui.activity.base.ActivityModule;
import ru.mamsy.weathersample.ui.activity.main.MainActivity;

/**
 * Авторизация.
 *
 * @author Maxim Berezin
 */
public class AddCityActivity extends BaseMVPActivity<AddCityView, AddCityPresenter> implements AddCityView {

    //region DI
    private AddCityComponent component;
    //endregion
    //region Views
    EditText addCity;
    private TextView errorMsg;
    private Button btn;
    private FrameLayout loadingView;
    //endregion


    public static Intent getCallingIntent(Context context) {
        return new Intent(context, AddCityActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        component = DaggerAddCityComponent.builder().appComponent(getAppComponent()).activityModule(new ActivityModule(this)).build();
        component.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_city);

        addCity = findViewById(R.id.addCity);
        addCity.setOnEditorActionListener(enterClickListener);
        errorMsg = findViewById(R.id.errorMsg);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(addBtnClickListener);
        loadingView = findViewById(R.id.loadingView);

        presenter.initialize();
    }

    @Override
    protected AddCityPresenter initPresenter() {
        presenter = component.authPresenter();
        return presenter;
    }

    @Override
    public void setAuthErrorMsgVisible(boolean visible) {
        errorMsg.setVisibility(visible ? View.VISIBLE : View.GONE);

    }

    @Override
    public void setEditTextUnderlineColor(ColorStateList colorStateList) {
        ViewCompat.setBackgroundTintList(addCity, colorStateList);
    }

    @Override
    public void navigateToMainActivity() {
        Intent intent = MainActivity.getCallingIntent(this);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        this.startActivity(intent);
        this.finish();
    }

    @Override
    public void hideSoftKeyboard() {
        InputMethodManager imm = (InputMethodManager) this.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = this.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(this);
        }
        if (imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    public void setLoadingViewVisible(boolean visible) {
        loadingView.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    /**
     * Слушатель нажатия кнопки добавить.
     */
    private View.OnClickListener addBtnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            presenter.onAddCityBtnClicked(addCity.getText().toString());
        }
    };

    /**
     * Слушатель кнопки enter
     */
    private TextView.OnEditorActionListener enterClickListener = new TextView.OnEditorActionListener() {

        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if ((actionId == EditorInfo.IME_NULL && event.getAction() == KeyEvent.ACTION_DOWN)
                    || actionId == EditorInfo.IME_ACTION_DONE) {
                presenter.onAddCityBtnClicked(addCity.getText().toString());
            }
            return true;
        }
    };
}

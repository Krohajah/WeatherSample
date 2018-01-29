package ru.mamsy.weathersample.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ru.mamsy.weathersample.R;
import ru.mamsy.weathersample.data.api.model.WeatherDataModel;
import ru.mamsy.weathersample.ui.adapter.rcadapter.WeatherDataAdapter;

/**
 * @author Maxim Berezin.
 */
public class CityWeatherFragment extends Fragment {

    //region ARGS
    private static final String ARG_WEATHER_DATA = "ARG_WEATHER_DATA";
    //endregion
    // region Views
    private TextView cityName;
    private RecyclerView recyclerView;
    //endregion
    //region Others
    private WeatherDataModel weatherDataModel;
    private WeatherDataAdapter weatherDataAdapter;

    public static CityWeatherFragment newInstance(WeatherDataModel weatherDataModel) {
        Bundle args = new Bundle();
        args.putParcelable(ARG_WEATHER_DATA, weatherDataModel);
        CityWeatherFragment cityWeatherFragment = new CityWeatherFragment();
        cityWeatherFragment.setArguments(args);
        return cityWeatherFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.weatherDataModel = getArguments().getParcelable(ARG_WEATHER_DATA);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_city_weather_item, container, false);

        cityName = view.findViewById(R.id.cityName);
        weatherDataAdapter = new WeatherDataAdapter();
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setAdapter(weatherDataAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));

        //  В идеале этим  должен управлять презентер.
        //  Но время поджимает...
        if (weatherDataModel != null) {
            cityName.setText(weatherDataModel.getCityName());
            weatherDataAdapter.setItems(weatherDataModel.getForecastsModelList());
        }

        return view;
    }
}

package ru.mamsy.weathersample.ui.adapter.rcadapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ru.mamsy.weathersample.R;
import ru.mamsy.weathersample.data.api.model.ForecastsModel;
import ru.mamsy.weathersample.ui.adapter.base.BaseRecyclerAdapter;

/**
 * @author Maxim Berezin.
 */
public class WeatherDataAdapter extends BaseRecyclerAdapter<ForecastsModel, WeatherDataAdapter.ViewHolder> {
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_forecast_model, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        int tempInt;
        int pressureInt;
        int humidityInt;
        //для простоты отобразим только целые числа без округления.
        holder.date.setText(items.get(position).getForecastDate());
        tempInt = (int) items.get(position).getTemp();
        holder.temp.setText(Integer.toString(tempInt));
        pressureInt = (int) items.get(position).getPressure();
        holder.pressure.setText(Integer.toString(pressureInt));
        humidityInt = items.get(position).getHumidity();
        holder.humidity.setText(Integer.toString(humidityInt));

    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView date;
        TextView temp;
        TextView pressure;
        TextView humidity;

        public ViewHolder(View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.date);
            temp = itemView.findViewById(R.id.temp);
            pressure = itemView.findViewById(R.id.pressure);
            humidity = itemView.findViewById(R.id.humidity);
        }
    }
}

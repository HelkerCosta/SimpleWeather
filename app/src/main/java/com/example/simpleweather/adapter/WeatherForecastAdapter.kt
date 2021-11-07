package com.example.simpleweather.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleweather.R

class WeatherForecastAdapter(): RecyclerView.Adapter<WeatherForecastAdapter.Viewholder>() {


    val weather = mutableListOf<WeatherTest>(
            WeatherTest("Monday", 22, 11),
            WeatherTest("Tuesday", 23, 16),
            WeatherTest("Wednesday", 22, 13),
            WeatherTest("Thursday", 22, 15),
            WeatherTest("Friday", 22, 17),
            WeatherTest("Monday", 22, 11),
            WeatherTest("Tuesday", 23, 16),
            WeatherTest("Wednesday", 22, 13),
            WeatherTest("Thursday", 22, 15),
            WeatherTest("Friday", 22, 17)
    )

    class Viewholder(view: View): RecyclerView.ViewHolder(view){
        val date: TextView
        val highTemp: TextView
        val lowTemp: TextView

        init {
            date = view.findViewById(R.id.row_weather_forecast_date_tv)
            highTemp = view.findViewById(R.id.row_weather_forecast_high_temp_tv)
            lowTemp = view.findViewById(R.id.row_weather_forecast_low_temp_tv)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_weather_forecast,parent, false)

        return Viewholder(view)
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        holder.date.text = weather[position].date
        holder.highTemp.text = weather[position].highTemp.toString() + "°"
        holder.lowTemp.text = weather[position].lowTemp.toString() + "°"
    }

    override fun getItemCount(): Int = weather.size

}

class WeatherTest(
        val date: String,
        val highTemp: Int,
        val lowTemp: Int
)
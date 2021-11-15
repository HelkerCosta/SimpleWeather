package com.example.simpleweather.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleweather.R

class WeatherForecastAdapter(): RecyclerView.Adapter<WeatherForecastAdapter.Viewholder>() {


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

    //private val differ = object : DiffUtil.ItemCallback<>

    override fun onBindViewHolder(holder: Viewholder, position: Int) {

    }

    override fun getItemCount(): Int = 0

}


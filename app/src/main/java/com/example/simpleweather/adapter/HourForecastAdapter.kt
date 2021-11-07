package com.example.simpleweather.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleweather.R


class HourForecastAdapter(): RecyclerView.Adapter<HourForecastAdapter.ViewHolder>(){

    val hourForecast = mutableListOf<HourForecastTest>(
            HourForecastTest("Now", 11),
            HourForecastTest("1pm", 20),
            HourForecastTest("2pm", 30),
            HourForecastTest("3pm", 33),
            HourForecastTest("4pm", 17),
            HourForecastTest("5pm", 12),
            HourForecastTest("6pm", 15),
            HourForecastTest("7pm", 15),
            HourForecastTest("8pm", 15),
            HourForecastTest("9pm", 15),
            HourForecastTest("10pm", 15),
            HourForecastTest("11pm", 15)
    )

     class ViewHolder(view: View): RecyclerView.ViewHolder(view){

         val time: TextView
         val temp: TextView

         init {
             time = view.findViewById(R.id.row_hour_forecast_time_tv)
             temp = view.findViewById(R.id.row_hour_forecast_temp_tv)
         }
     }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_hour_forecast,parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.time.text = hourForecast[position].time
        holder.temp.text = hourForecast[position].temp.toString() + "°"
    }

    override fun getItemCount(): Int = hourForecast.size
}

data class HourForecastTest(
        val time: String,
        val temp: Int
)
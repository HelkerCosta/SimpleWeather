package com.example.simpleweather.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleweather.R
import com.example.simpleweather.data.remote.dto.Daily
import com.example.simpleweather.domain.model.DayForecast
import com.example.simpleweather.util.getDate
import com.example.simpleweather.util.getWeatherIcon

class WeatherForecastAdapter(): RecyclerView.Adapter<WeatherForecastAdapter.Viewholder>() {


    class Viewholder(view: View): RecyclerView.ViewHolder(view){
        val date: TextView
        val highTemp: TextView
        val lowTemp: TextView
        val iconImg: ImageView

        init {
            date = view.findViewById(R.id.row_weather_forecast_date_tv)
            highTemp = view.findViewById(R.id.row_weather_forecast_high_temp_tv)
            lowTemp = view.findViewById(R.id.row_weather_forecast_low_temp_tv)
            iconImg = view.findViewById(R.id.row_weather_icon_iv)
        }

    }

    private val differCallback = object : DiffUtil.ItemCallback<Daily>(){
        override fun areItemsTheSame(oldItem: Daily, newItem: Daily): Boolean = oldItem == newItem

        override fun areContentsTheSame(oldItem: Daily, newItem: Daily): Boolean = oldItem == newItem
    }

    private val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_weather_forecast,parent, false)
        return Viewholder(view)
    }



    override fun onBindViewHolder(holder: Viewholder, position: Int) {

        holder.date.text = getDate(differ.currentList[position].dt)
        //holder.iconImg.setImageResource(getWeatherIcon(differ.currentList[position].weatherx[0].icon))
        holder.highTemp.text = differ.currentList[position].temp.max.toString()
        holder.lowTemp.text = differ.currentList[position].temp.min.toString()
    }

    fun setData(list: List<Daily>){
        differ.submitList(list)
    }

    override fun getItemCount(): Int = differ.currentList.size

}


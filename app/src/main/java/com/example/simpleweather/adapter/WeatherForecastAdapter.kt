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
import com.example.simpleweather.domain.model.DayForecast
import com.example.simpleweather.util.*
import kotlin.math.roundToInt

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

    private val differCallback = object : DiffUtil.ItemCallback<DayForecast>(){
        override fun areItemsTheSame(oldItem: DayForecast, newItem: DayForecast): Boolean = oldItem == newItem

        override fun areContentsTheSame(oldItem: DayForecast, newItem: DayForecast): Boolean = oldItem == newItem
    }

    private val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_weather_forecast,parent, false)
        return Viewholder(view)
    }



    override fun onBindViewHolder(holder: Viewholder, position: Int) {

        val dayForecast = differ.currentList[position]

        val resource = holder.itemView.resources

        holder.date.text = getDateFormat(getMonthDay(dayForecast.date), getWeekDay(dayForecast.date))
        holder.iconImg.setImageResource(getWeatherIcon(dayForecast.icon))
        holder.highTemp.text = resource.getString(R.string.temperature, dayForecast.tempMax.roundToInt())
        holder.lowTemp.text = resource.getString(R.string.temperature, dayForecast.tempMin.roundToInt())
    }

    fun setData(list: List<DayForecast>){
        differ.submitList(list)
    }

    override fun getItemCount(): Int = differ.currentList.size
}


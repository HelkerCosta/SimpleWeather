package com.example.simpleweather.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleweather.R
import com.example.simpleweather.network.response.Hourly
import com.example.simpleweather.util.convertHour
import java.math.RoundingMode
import java.util.*


class HourForecastAdapter(): RecyclerView.Adapter<HourForecastAdapter.ViewHolder>(){

     class ViewHolder(view: View): RecyclerView.ViewHolder(view){

         val time: TextView = view.findViewById(R.id.row_hour_forecast_time_tv)
         val temp: TextView = view.findViewById(R.id.row_hour_forecast_temp_tv)
         val img: ImageView = view.findViewById(R.id.row_hour_weather_icon_iv)

     }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_hour_forecast,parent, false)
        return ViewHolder(view)
    }

    private val differCallBack = object : DiffUtil.ItemCallback<Hourly>(){
        override fun areItemsTheSame(oldItem: Hourly, newItem: Hourly): Boolean = oldItem == newItem

        override fun areContentsTheSame(oldItem: Hourly, newItem: Hourly): Boolean = oldItem == newItem
    }

    private val differ = AsyncListDiffer(this,differCallBack)

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val date = Calendar.getInstance()
        date.timeInMillis = differ.currentList[position].dt * 1000

        holder.time.text = convertHour(date.get(Calendar.HOUR_OF_DAY), date.get(Calendar.AM_PM))
        holder.temp.text = differ.currentList[position].temp.toBigDecimal().setScale(0,RoundingMode.UP).toString()

        when(differ.currentList[position].weather[0].icon)
        {
            "01d" -> holder.img.setImageResource(R.drawable.ic_sunny)
            "02d" -> holder.img.setImageResource(R.drawable.ic_partly_cloudy)
            "03d" -> holder.img.setImageResource(R.drawable.ic_clounds_day)
            "04d" -> holder.img.setImageResource(R.drawable.ic_clounds_day)
            "09d" -> holder.img.setImageResource(R.drawable.ic_rainy)
            "10d" -> holder.img.setImageResource(R.drawable.ic_rainy)
            "11d" -> holder.img.setImageResource(R.drawable.ic_thuderstorm)
            "13d" -> holder.img.setImageResource(R.drawable.ic_snow)
            "50d" -> holder.img.setImageResource(R.drawable.ic_fog)

            "01n" -> holder.img.setImageResource(R.drawable.ic_clear_night)
            "02n" -> holder.img.setImageResource(R.drawable.ic_partly_cloudy_night)
            "03n" -> holder.img.setImageResource(R.drawable.ic_cloudy_night)
            "04n" -> holder.img.setImageResource(R.drawable.ic_cloudy_night)
            "09n" -> holder.img.setImageResource(R.drawable.ic_rainy_night)
            "10n" -> holder.img.setImageResource(R.drawable.ic_rainy_night)
            "11n" -> holder.img.setImageResource(R.drawable.ic_thuderstorm_night)
            "13n" -> holder.img.setImageResource(R.drawable.ic_snow_night)
            "50n" -> holder.img.setImageResource(R.drawable.ic_fog_night)

            else -> holder.img.setImageResource(R.drawable.ic_launcher_background)
        }

    }

    fun setData(list: List<Hourly>){
        differ.submitList(list)
    }

    override fun getItemCount(): Int = differ.currentList.size

}

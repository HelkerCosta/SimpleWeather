package com.example.simpleweather.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleweather.R
import com.example.simpleweather.data.remote.dto.Hourly
import com.example.simpleweather.util.convertHour
import com.example.simpleweather.util.getTimeAmPm
import com.example.simpleweather.util.getWeatherIcon
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

        holder.time.text = getTimeAmPm(differ.currentList[position].dt)
        holder.temp.text = differ.currentList[position].temp.toBigDecimal().setScale(0,RoundingMode.UP).toString()
        holder.img.setImageResource(getWeatherIcon(differ.currentList[position].weather[0].icon))

    }

    fun setData(list: List<Hourly>){
        differ.submitList(list)
    }

    override fun getItemCount(): Int = differ.currentList.size

}

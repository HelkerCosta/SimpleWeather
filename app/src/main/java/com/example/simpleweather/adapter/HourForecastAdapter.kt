package com.example.simpleweather.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleweather.R
import com.example.simpleweather.network.response.Hourly
import java.math.RoundingMode
import java.time.Instant
import java.util.*


class HourForecastAdapter(): RecyclerView.Adapter<HourForecastAdapter.ViewHolder>(){

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

    private val differCallBack = object : DiffUtil.ItemCallback<Hourly>(){
        override fun areItemsTheSame(oldItem: Hourly, newItem: Hourly): Boolean = oldItem == newItem

        override fun areContentsTheSame(oldItem: Hourly, newItem: Hourly): Boolean = oldItem == newItem
    }

    private val differ = AsyncListDiffer(this,differCallBack)

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val date = Calendar.getInstance()
        date.timeInMillis = differ.currentList[position].dt * 1000

        date.get(Calendar.HOUR)

        holder.time.text = date.get(Calendar.HOUR_OF_DAY).toString()
        holder.temp.text = differ.currentList[position].temp.toBigDecimal().setScale(0,RoundingMode.UP).toString()
    }

    fun setData(list: List<Hourly>){
        differ.submitList(list)
    }

    override fun getItemCount(): Int = differ.currentList.size

}

package com.example.simpleweather.ui.main

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleweather.R
import com.example.simpleweather.adapter.HourForecastAdapter
import com.example.simpleweather.adapter.HourForecastTest
import com.example.simpleweather.adapter.WeatherForecastAdapter

class MainFragment: Fragment(R.layout.fragment_main) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val hourForecastRecyclerView = view.findViewById<RecyclerView>(R.id.main_hour_forecast_rv)
        val weatherForecastRecyclerView = view.findViewById<RecyclerView>(R.id.main_weather_forecast_rv)

        hourForecastRecyclerView.apply {
            adapter = HourForecastAdapter()
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }

        weatherForecastRecyclerView.apply {
            adapter = WeatherForecastAdapter()
            layoutManager = LinearLayoutManager(context)
        }
    }
}
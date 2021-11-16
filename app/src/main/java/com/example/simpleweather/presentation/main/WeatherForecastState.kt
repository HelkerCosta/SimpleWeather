package com.example.simpleweather.presentation.main

import com.example.simpleweather.domain.model.CurrentForecast
import com.example.simpleweather.domain.model.DayForecast

data class WeatherForecastState(
    val isLoading: Boolean = false,
    val currentForecast: CurrentForecast = CurrentForecast(),
    val error: String = "",
    val dayForecast: DayForecast = DayForecast()
)

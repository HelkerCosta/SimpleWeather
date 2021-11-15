package com.example.simpleweather.presentation.main

import com.example.simpleweather.domain.model.CurrentForecast

data class WeatherForecastState(
    val isLoading: Boolean = false,
    val currentForecast: CurrentForecast = CurrentForecast(),
    val error: String = ""
)

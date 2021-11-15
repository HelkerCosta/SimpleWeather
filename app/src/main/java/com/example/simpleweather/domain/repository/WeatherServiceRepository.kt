package com.example.simpleweather.domain.repository

import com.example.simpleweather.data.remote.dto.WeatherResponseDto
import com.example.simpleweather.domain.model.CurrentForecast
import com.example.simpleweather.domain.model.ForecastAddress

interface WeatherServiceRepository {

    fun getCurrentAddress(): ForecastAddress
    suspend fun getCurrentWeather(lat: Double, lon: Double): WeatherResponseDto
    suspend fun getWeatherFavorites(): CurrentForecast
}
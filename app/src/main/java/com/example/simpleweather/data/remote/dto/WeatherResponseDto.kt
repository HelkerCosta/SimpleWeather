package com.example.simpleweather.data.remote.dto

import androidx.lifecycle.Transformations.map
import com.example.simpleweather.domain.model.CurrentForecast
import com.example.simpleweather.domain.model.DayForecast
import kotlin.math.roundToInt

data class WeatherResponseDto(
        val current: Current,
        val daily: List<Daily>,
        val hourly: List<Hourly>,
        val lat: Double,
        val lon: Double,
        val minutely: List<Minutely>,
        val timezone: String,
        val timezone_offset: Int
)

fun WeatherResponseDto.toCurrentForecast(): CurrentForecast{
    return CurrentForecast(
            time = current.dt,
            sunRise = current.sunrise,
            sunSet = current.sunset,
            temp = current.temp.roundToInt(),
            feelsLike = current.feels_like.roundToInt(),
            windSpeed = current.wind_speed.roundToInt(),
            windDeg = current.wind_deg,
            icon = current.weather[0].icon,
            description = current.weather[0].description,
            hourly = hourly,
            propabilityRain = hourly[0].pop.roundToInt(),
            day = daily.map {
                DayForecast(
                        date = it.dt,
                        tempMax = it.temp.max,
                        tempMin = it.temp.min,
                        icon = it.weather[0].icon
                )
            }
    )
}





/*
data class CurrentForecast(
        val time: Long,
        val sunRise: Long,
        val sunSet: Long,
        val temp: Double,
        val feelsLike: Double,
        val windSpeed: Double,
        val windDeg: Double,
        val icon: String
)


data class Current(
        val clouds: Int,
        val dew_point: Double,
        val dt: Int,
        val feels_like: Double,
        val humidity: Int,
        val pressure: Int,
        val rain: Rain,
        val sunrise: Long,
        val sunset: Long,
        val temp: Double,
        val uvi: Double,
        val visibility: Int,
        val weather: List<Weather>,
        val wind_deg: Int,
        val wind_speed: Double
)

 */
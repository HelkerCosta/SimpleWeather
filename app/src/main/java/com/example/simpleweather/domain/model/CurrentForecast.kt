package com.example.simpleweather.domain.model

import com.example.simpleweather.data.remote.dto.Hourly

data class CurrentForecast(
        val time: Long,
        val sunRise: Long,
        val sunSet: Long,
        val temp: Double,
        val feelsLike: Double,
        val windSpeed: Double,
        val windDeg: Int,
        val icon: String,
        val description: String,
        val hourly: List<Hourly>
)


/*
"current":{
      "dt":1636079344,
      "sunrise":1636030573,
      "sunset":1636069743,
      "temp":283.16,
      "feels_like":282.33,
      "pressure":1024,
      "humidity":81,
      "dew_point":280.05,
      "uvi":0,
      "clouds":90,
      "visibility":10000,
      "wind_speed":2.06,
      "wind_deg":90,
      "weather":[
         {
            "id":804,
            "main":"Clouds",
            "description":"overcast clouds",
            "icon":"04n"
         }
 */
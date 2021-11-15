package com.example.simpleweather.domain.model

import com.example.simpleweather.data.remote.dto.Hourly
import com.example.simpleweather.data.remote.dto.Rain

data class CurrentForecast(
        val time: Long = -1,
        val sunRise: Long = -1,
        val sunSet: Long = -1,
        val temp: Int = -1,
        val feelsLike: Int = -1,
        val windSpeed: Int = -1,
        val windDeg: Int = -1,
        val icon: String = "",
        val description: String = "",
        val propabilityRain: Int = 0,
        val hourly: List<Hourly> = emptyList()
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
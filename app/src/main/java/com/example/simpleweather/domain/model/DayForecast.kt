package com.example.simpleweather.domain.model

data class DayForecast(
        val sunRise: Double,
        val sunSet: Double,
        val tempMax: Double,
        val tempMin: Double,
        val feelLike: Double,
        val icon: String
)

/*
"dt":1636048800,
         "sunrise":1636030573,
         "sunset":1636069743,
         "moonrise":1636029300,
         "moonset":1636070100,
         "moon_phase":0,
         "temp":{
            "day":284.31,
            "min":280.62,
            "max":285.51,
            "night":283.78,
            "eve":283.77,
            "morn":280.64
         },
         "feels_like":{
            "day":283.36,
            "night":282.86,
            "eve":282.87,
            "morn":277.76
         },
         "pressure":1027,
         "humidity":72,
         "dew_point":279.07,
         "wind_speed":5.84,
         "wind_deg":36,
         "wind_gust":7.64,
         "weather":[
            {
               "id":804,
               "main":"Clouds",
               "description":"overcast clouds",
               "icon":"04d"
            }
         ],
         "clouds":99,
 */
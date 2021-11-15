package com.example.simpleweather.domain.model

data class HourForecast(
        val time: Long,
        val temp: Double,
        val icon: String,
)

/*
"dt":1636081200,
"temp":283.43,
"feels_like":282.55,
"pressure":1024,
"humidity":78,
"dew_point":279.77,
"uvi":0,
"clouds":92,
"visibility":10000,
"wind_speed":1.47,
"wind_deg":89,
"wind_gust":1.29,
"weather":[
{
    "id":804,
    "main":"Clouds",
    "description":"overcast clouds",
    "icon":"04n"
}

 */

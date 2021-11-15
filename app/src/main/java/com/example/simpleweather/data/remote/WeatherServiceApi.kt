package com.example.simpleweather.data.remote

import com.example.simpleweather.data.remote.dto.WeatherResponseDto
import com.example.simpleweather.util.Resource
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherServiceApi
{
        @GET("onecall")
        suspend fun getWeather(
                @Query("lat") lat: Double,
                @Query("lon") lon: Double,
                @Query("units") units: String =  "imperial",
                @Query("appid") appId: String
        ): WeatherResponseDto
}



// https://api.openweathermap.org/data/2.5/onecall?lat=26.709489&lon=-80.052151&appid=0cd6341a128d0f2a7eacc8f0dbdd7121  -- My Location

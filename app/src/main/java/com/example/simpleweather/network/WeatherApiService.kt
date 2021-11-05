package com.example.simpleweather.network

import com.example.simpleweather.network.response.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherApiService
{
        @GET("onecall")
        suspend fun getWeather(
                @Query("lat") lat: Double,
                @Query("lon") lon: Double,
                @Query("appid") appId: String
        ): Response<WeatherResponse>
}



// https://api.openweathermap.org/data/2.5/onecall?lat=26.709489&lon=-80.052151&appid=0cd6341a128d0f2a7eacc8f0dbdd7121  -- My Location

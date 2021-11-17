package com.example.simpleweather.data.repository

import android.annotation.SuppressLint
import android.location.Criteria
import android.location.Geocoder
import android.location.LocationManager
import com.example.simpleweather.BuildConfig
import com.example.simpleweather.data.remote.WeatherServiceApi
import com.example.simpleweather.data.remote.dto.WeatherResponseDto
import com.example.simpleweather.domain.model.CurrentForecast
import com.example.simpleweather.domain.model.ForecastAddress
import com.example.simpleweather.domain.repository.WeatherServiceRepository
import javax.inject.Inject


class WeatherServiceRepositoryImpl @Inject constructor(
        private val weatherApi: WeatherServiceApi,
        private val locationManager: LocationManager,
        private val geoCoder: Geocoder
        ) : WeatherServiceRepository
{


    override suspend fun getCurrentWeather(lat: Double, lon: Double): WeatherResponseDto {
        return weatherApi.getWeather(lat, lon, "imperial", BuildConfig.OW_KEY);
    }

    @SuppressLint("MissingPermission")
    override fun getCurrentAddress(): ForecastAddress {
        val criteria = Criteria()
       val provider = locationManager.getBestProvider(criteria,false)
        val location = provider?.let { locationManager.getLastKnownLocation(it) }
        val cityInfo = geoCoder.getFromLocation(location!!.latitude, location.longitude, 1)

        return ForecastAddress(
                cityInfo[0].locality,
                cityInfo[0].adminArea,
                cityInfo[0].latitude,
                cityInfo[0].longitude,
        )
    }

    override suspend fun getWeatherFavorites(): CurrentForecast {
        return CurrentForecast()
    }
}
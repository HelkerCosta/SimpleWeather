package com.example.simpleweather.repository

import android.annotation.SuppressLint
import android.location.Criteria
import android.location.Geocoder
import android.location.LocationManager
import android.util.Log
import com.example.simpleweather.domain.Address
import com.example.simpleweather.network.WeatherApiService
import com.example.simpleweather.network.response.WeatherResponse
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val weatherApi: WeatherApiService, private val locationManager: LocationManager, private val geoCoder: Geocoder) {

    suspend fun getWeather(lat: Double, lon: Double): Response<WeatherResponse> {
        val respose = weatherApi.getWeather(lat, lon, "imperial","0cd6341a128d0f2a7eacc8f0dbdd7121")
        Log.d("Location", "lat $lat, Lon $lon")
        return respose;
    }

    @SuppressLint("MissingPermission")
    fun getUserLocation() : Address{
        val criteria = Criteria()
        val provider = locationManager.getBestProvider(criteria,false)
        val location = provider?.let { locationManager.getLastKnownLocation(it) }
        val cityInfo = geoCoder.getFromLocation(location!!.latitude, location.longitude, 1)

        return Address(
                cityInfo[0].locality,
                cityInfo[0].adminArea,
                location.latitude,
                location.longitude
                )
    }
}
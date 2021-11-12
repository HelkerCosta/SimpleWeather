package com.example.simpleweather.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpleweather.network.response.WeatherResponse
import com.example.simpleweather.repository.Repository
import com.example.simpleweather.util.convert
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import java.math.RoundingMode
import javax.inject.Inject
import javax.inject.Scope
import kotlin.math.roundToInt

@HiltViewModel
class MainFragmentViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _weatherResponse = MutableLiveData<Response<WeatherResponse>>()
    val items: LiveData<Response<WeatherResponse>> = _weatherResponse
    private var lat: Double = 0.0
    private var lon: Double = 0.0
    var stateName: String = ""
    var cityName: String = ""
   // var currentTemperature: Double = 0.0

    val currentWeatherDescription: MutableLiveData<String> by lazy{
        MutableLiveData<String>()
    }

    val currentTemperature: MutableLiveData<String> by lazy{
        MutableLiveData<String>()
    }

    val currentPopPrecipitation: MutableLiveData<String> by lazy{
        MutableLiveData<String>()
    }

    val currentWindSpeed: MutableLiveData<String> by lazy{
        MutableLiveData<String>()
    }


    init {
        getUserLocation()
        getWeather()
    }

    private fun getWeather(){
        viewModelScope.launch {
            _weatherResponse.value = repository.getWeather(lat, lon)

            if(_weatherResponse.value!!.isSuccessful){
                currentWeatherDescription.value = _weatherResponse.value!!.body()?.current!!.weather[0].main
                currentTemperature.value = _weatherResponse.value!!.body()?.current!!.temp.roundToInt().toString()
                currentPopPrecipitation.value = if(_weatherResponse.value!!.body()!!.hourly[0].pop > 0.3) "${(_weatherResponse.value!!.body()!!.hourly[0].pop * 100).roundToInt()}%" else "0%"
                currentWindSpeed.value = "${_weatherResponse.value!!.body()!!.hourly[0].wind_speed.roundToInt()} m/h"
            }


        }
    }

    private fun getUserLocation(){
        val address = repository.getUserLocation()
        stateName = convert(address.state)
        cityName = address.city
        lat = address.lan
        lon = address.long
    }

}
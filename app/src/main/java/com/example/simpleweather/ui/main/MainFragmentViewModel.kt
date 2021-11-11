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
import javax.inject.Inject
import javax.inject.Scope

@HiltViewModel
class MainFragmentViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _weatherResponse = MutableLiveData<Response<WeatherResponse>>()
    val items: LiveData<Response<WeatherResponse>> = _weatherResponse
    private var lat: Double = 0.0
    private var lon: Double = 0.0
    var stateName: String = ""
    var cityName: String = ""


    init {
        getUserLocation()
        getWeather()
    }

    private fun getWeather(){
        viewModelScope.launch {
            _weatherResponse.value = repository.getWeather(lat, lon)
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
package com.example.simpleweather.presentation.main


import androidx.lifecycle.ViewModel
import com.example.simpleweather.domain.model.CurrentForecast
import com.example.simpleweather.domain.use_case.get_weather.GetWeatherUseCase
import com.example.simpleweather.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onEach

import javax.inject.Inject

@HiltViewModel
class MainFragmentViewModel @Inject constructor(
    private val getWeatherUseCase: GetWeatherUseCase
) : ViewModel() {

    private val _weatherForecast = MutableStateFlow(Resource<CurrentForecast>)
    val weatherForecast: StateFlow<Resource<CurrentForecast>> = _weatherForecast

    init {

    }

    private fun getWeatherForecast(lat: Double, lon: Double){
        getWeatherUseCase(lat, lon).onEach {
            when(it){
                 is Resource.Success ->{

                 }

                is Resource.Error ->{

                }

                is Resource.Loading ->{

                }
            }
        }
    }

}
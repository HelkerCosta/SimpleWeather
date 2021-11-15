package com.example.simpleweather.presentation.main


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpleweather.domain.model.CurrentForecast
import com.example.simpleweather.domain.use_case.get_weather.GetWeatherUseCase
import com.example.simpleweather.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*

import javax.inject.Inject

@HiltViewModel
class MainFragmentViewModel @Inject constructor(
    private val getWeatherUseCase: GetWeatherUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(WeatherForecastState())
    val uiState: StateFlow<WeatherForecastState> = _uiState

    init {
        getWeatherForecast(26.714439, -80.054947)
    }


    private fun getWeatherForecast(lat: Double, lon: Double){
        getWeatherUseCase(lat, lon).onEach {
            when(it){
                 is Resource.Success ->{
                     _uiState.value = WeatherForecastState(currentForecast = it.data ?: CurrentForecast(), isLoading = false)
                 }

                is Resource.Error ->{
                    _uiState.value = WeatherForecastState(error = it.message ?: "An unexpected error occurred", isLoading = false)
                }

                is Resource.Loading ->{
                    _uiState.value = WeatherForecastState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}
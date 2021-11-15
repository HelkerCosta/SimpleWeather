package com.example.simpleweather.domain.use_case.get_weather

import com.example.simpleweather.data.remote.dto.toCurrentForecast
import com.example.simpleweather.domain.model.CurrentForecast
import com.example.simpleweather.domain.repository.WeatherServiceRepository
import com.example.simpleweather.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(
    private val repository: WeatherServiceRepository
) {

    operator fun invoke(lat: Double, lon: Double): Flow<Resource<CurrentForecast>> = flow {
        try {
            emit(Resource.Loading<CurrentForecast>())
            val weather = repository.getCurrentWeather(lat, lon).toCurrentForecast()
            emit(Resource.Success(weather))
        } catch (e: HttpException){
            emit(Resource.Error<CurrentForecast>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException){
            emit(Resource.Error<CurrentForecast>(e.localizedMessage?: "No internet connection"))
        }
    }
}
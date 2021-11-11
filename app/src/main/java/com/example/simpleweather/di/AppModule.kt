package com.example.simpleweather.di

import android.content.Context
import android.location.Geocoder
import android.location.LocationManager
import com.example.simpleweather.network.WeatherApiService
import com.example.simpleweather.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideWeatherAPI(): WeatherApiService {
        return Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WeatherApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideLocationManager(@ApplicationContext context: Context): LocationManager{
        return context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    }

    @Singleton
    @Provides
    fun provideGeoCoder(@ApplicationContext context: Context): Geocoder{
        return Geocoder(context)
    }

    @Singleton
    @Provides
    fun provideRepo(
            api: WeatherApiService,
            locationManger: LocationManager,
            geoCoder: Geocoder
    ): Repository {
        return Repository(api, locationManger, geoCoder) as Repository
    }

}
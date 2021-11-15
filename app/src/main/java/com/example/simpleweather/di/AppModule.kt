package com.example.simpleweather.di

import android.content.Context
import android.location.Geocoder
import android.location.LocationManager
import com.example.simpleweather.data.remote.WeatherServiceApi
import com.example.simpleweather.data.repository.WeatherServiceRepositoryImpl
import com.example.simpleweather.util.Constant
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
object AppModule {

    @Singleton
    @Provides
    fun provideWeatherAPI(): WeatherServiceApi {
        return Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WeatherServiceApi::class.java)
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
            api: WeatherServiceApi,
            locationManger: LocationManager,
            geoCoder: Geocoder
    ): WeatherServiceRepositoryImpl {
        return WeatherServiceRepositoryImpl(api, locationManger, geoCoder) as WeatherServiceRepositoryImpl
    }

}
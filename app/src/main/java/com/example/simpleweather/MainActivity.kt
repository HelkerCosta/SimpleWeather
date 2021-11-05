package com.example.simpleweather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.Navigation
import com.example.simpleweather.network.WeatherApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getWeather()
    }

    private fun setUpView(){
        val navController = Navigation.findNavController(this,R.id.nav_host_fragment)
    }

    private fun getWeather() {

        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val service = retrofit.create(WeatherApiService::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            val respose = service.getWeather(26.709489, -80.052151, "0cd6341a128d0f2a7eacc8f0dbdd7121")

            withContext(Dispatchers.Main){
                if (respose.isSuccessful)
                {
                    Log.d("Main Activity", respose.body().toString())
                }else{
                    Log.d("Main Activity", "response is fail")
                }

            }
        }
    }
}


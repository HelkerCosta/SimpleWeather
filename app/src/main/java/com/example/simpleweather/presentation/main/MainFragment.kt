package com.example.simpleweather.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simpleweather.R
import com.example.simpleweather.adapter.HourForecastAdapter
import com.example.simpleweather.adapter.WeatherForecastAdapter
import com.example.simpleweather.data.remote.dto.Daily
import com.example.simpleweather.data.remote.dto.Hourly
import com.example.simpleweather.databinding.FragmentMainBinding
import com.example.simpleweather.domain.model.DayForecast
import com.example.simpleweather.util.Resource
import kotlinx.coroutines.flow.collectLatest

class MainFragment: Fragment(R.layout.fragment_main) {
    private lateinit var mainFragmentViewModel: MainFragmentViewModel
    private lateinit var _binding: FragmentMainBinding
    private lateinit var hourForecastAdapter: HourForecastAdapter
    private lateinit var weatherForecastAdapter: WeatherForecastAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentMainBinding.inflate(inflater,container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainFragmentViewModel =
            ViewModelProvider(requireActivity()).get(MainFragmentViewModel::class.java)

        hourForecastAdapter = HourForecastAdapter()
        weatherForecastAdapter = WeatherForecastAdapter()

        lifecycleScope.launchWhenCreated {
            mainFragmentViewModel.uiState.collectLatest {

                when(it.isLoading){
                    true -> {

                    }
                    else ->{
                        _binding.mainCurrentTempTv.text = getString(R.string.temperature, it.currentForecast.temp)
                        _binding.mainCurrentWeatherDescription.text = it.currentForecast.description
                        _binding.mainPrecipitationTv.text = getString(R.string.probability_of_rain, it.currentForecast.propabilityRain)
                        _binding.mainWindSpeedTv.text = getString(R.string.wind_speed, it.currentForecast.windSpeed)
                        setHourRecyclerViewWithData(it.currentForecast.hourly)
                        setWeatherRecyclerViewWithData(it.currentForecast.day)
                    }
                }

            }
        }
    }

    private fun setHourRecyclerViewWithData(list: List<Hourly>){

        hourForecastAdapter.setData(list)

        _binding.mainHourForecastRv.apply {
            adapter = hourForecastAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
    }

    private fun setWeatherRecyclerViewWithData(list: List<DayForecast>){
        weatherForecastAdapter.setData(list)

        _binding.mainWeatherForecastRv.apply {
            adapter = weatherForecastAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
}
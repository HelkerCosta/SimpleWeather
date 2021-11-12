package com.example.simpleweather.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleweather.R
import com.example.simpleweather.adapter.HourForecastAdapter
import com.example.simpleweather.adapter.WeatherForecastAdapter
import com.example.simpleweather.databinding.FragmentMainBinding
import com.example.simpleweather.util.convert
import retrofit2.Response

class MainFragment: Fragment(R.layout.fragment_main) {
    private lateinit var mainFragmentViewModel: MainFragmentViewModel
    private lateinit var _binding: FragmentMainBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentMainBinding.inflate(inflater,container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainFragmentViewModel = ViewModelProvider(requireActivity()).get(MainFragmentViewModel::class.java)

        val hourForecastAdapter = HourForecastAdapter()

        mainFragmentViewModel.items.observe(viewLifecycleOwner) observer@{ response ->
            if (response.isSuccessful){
                Log.d("MainFragment", "Response is SUCCESSFULL")
                response.body().let {
                    hourForecastAdapter.setData(it!!.hourly)
                    Log.d("MainFragment", it.hourly.toString())
                }
                return@observer
            }

            Log.d("MainFragment", "Response is FAILED")
        }

        _binding.mainHourForecastRv.apply {
            adapter = hourForecastAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }

        _binding.mainWeatherForecastRv.apply {
            adapter = WeatherForecastAdapter()
            layoutManager = LinearLayoutManager(context)
        }

        mainFragmentViewModel.currentWeatherDescription.observe(viewLifecycleOwner){
            _binding.mainCurrentWeatherDescription.text = it
        }

        mainFragmentViewModel.currentTemperature.observe(viewLifecycleOwner){
            _binding.mainCurrentTempTv.text = it.toString()
        }

        mainFragmentViewModel.currentPopPrecipitation.observe(viewLifecycleOwner){
            _binding.mainPrecipitationTv.text = it
        }

        mainFragmentViewModel.currentWindSpeed.observe(viewLifecycleOwner){
            _binding.mainWindSpeedTv.text = it
        }

        _binding.mainCityNameTv.text = getString(R.string.city_name_with_state, mainFragmentViewModel.cityName, mainFragmentViewModel.stateName)
    }

}
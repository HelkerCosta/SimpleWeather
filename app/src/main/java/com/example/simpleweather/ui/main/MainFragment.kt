package com.example.simpleweather.ui.main

import android.os.Bundle
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
import com.example.simpleweather.adapter.HourForecastTest
import com.example.simpleweather.adapter.WeatherForecastAdapter
import com.example.simpleweather.databinding.FragmentMainBinding

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

        _binding.mainHourForecastRv.apply {
            adapter = HourForecastAdapter()
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }

        _binding.mainWeatherForecastRv.apply {
            adapter = WeatherForecastAdapter()
            layoutManager = LinearLayoutManager(context)
        }
    }

}
package com.example.weatherx.presentation

import com.example.weatherx.domain.weather.WeatherInfo

data class WeatherState(
    val weatherInfo : WeatherInfo? = null,
    val isLoading :Boolean? = null,
    val error :String? = null
)

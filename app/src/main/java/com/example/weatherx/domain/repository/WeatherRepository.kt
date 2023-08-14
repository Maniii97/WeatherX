package com.example.weatherx.domain.repository

import com.example.weatherx.domain.util.Resource
import com.example.weatherx.domain.weather.WeatherInfo

interface WeatherRepository {

    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>

}
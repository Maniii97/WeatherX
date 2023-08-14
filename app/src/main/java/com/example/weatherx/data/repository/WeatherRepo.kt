package com.example.weatherx.data.repository

import com.example.weatherx.data.mappers.toWeatherInfo
import com.example.weatherx.data.remote.WeatherApi
import com.example.weatherx.domain.repository.WeatherRepository
import com.example.weatherx.domain.util.Resource
import com.example.weatherx.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepo @Inject constructor(
    private val api: WeatherApi
): WeatherRepository {

    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {

        return try {
            Resource.Success(
                data = api.getWeather(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        } catch (e : Exception){
            e.printStackTrace()
            Resource.Error(e.message ?: "Unknown Error")
        }
    }
}
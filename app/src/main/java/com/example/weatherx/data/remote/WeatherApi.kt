package com.example.weatherx.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("v1/forecast?hourly=temperature_2m,weathercode,relativehumidity_2m,windspeed_10m,pressure_msl,visibility")
    suspend fun getWeather(
        @Query("latitude") lat : Double,
        @Query("longitude") long : Double
    ) : WeatherDto
}
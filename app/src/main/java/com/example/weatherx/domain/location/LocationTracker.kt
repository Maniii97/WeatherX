package com.example.weatherx.domain.location

import android.location.Location

interface LocationTracker {

    suspend fun getLocation() : Location?
}
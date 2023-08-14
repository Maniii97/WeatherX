package com.example.weatherx.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.example.weatherx.R
import com.example.weatherx.domain.weather.WeatherData
import java.time.format.DateTimeFormatter


@Composable
fun HourlyDisplay() {
    
}

@Composable
fun WeatherHourly(
    weatherData: WeatherData,
    modifier: Modifier = Modifier,
    ) {
    val time = remember(weatherData){
        weatherData.time.format(
            DateTimeFormatter.ofPattern("HH:mm")
        )
    }
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = time,
            color = Color.LightGray
        )
        WeatherRow(weatherData = weatherData)

    }
}

@Composable
fun WeatherRow(
    weatherData: WeatherData,
    modifier: Modifier = Modifier,
) {
    Row (
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(painter = painterResource(id = weatherData.weatherType.iconRes),
            contentDescription = null,
            modifier = Modifier.width(20.dp)
        )
        Text(text = "${weatherData.temperatureCelsius}°C",
            color = Color.White,
            fontFamily = FontFamily(Font(R.font.sfpro_medium))
        )

    }
    
}
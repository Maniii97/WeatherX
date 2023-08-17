package com.example.weatherx.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
    import androidx.compose.ui.unit.dp
import com.example.weatherx.R
import com.example.weatherx.domain.weather.WeatherData
import java.time.format.DateTimeFormatter


@Composable
fun HourlyDisplay(
    state: WeatherState,
    modifier: Modifier = Modifier

) {

    state.weatherInfo?.weatherDataPerDay?.get(0)?.let { data ->

        Box(modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0XFF26282b))
            .padding(17.dp)
        ) {
            LazyRow(content = {
                items(data) { weatherData ->
                    WeatherHourly(
                        weatherData = weatherData,
                        modifier = Modifier
                            .height(100.dp)
                            .padding(horizontal = 16.dp)
                    )
                }
            }
            )
        }

    }
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
    ) {
        Text(
            text = time,
            fontFamily = FontFamily(Font(R.font.sfpro_medium)),
            color = Color.LightGray
        )
        Spacer(modifier = Modifier.height(4.dp))
        WeatherRow(weatherData = weatherData)

    }
}

@Composable
fun WeatherRow(
    weatherData: WeatherData,
    modifier: Modifier = Modifier,
) {
    Row (
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(painter = painterResource(id = weatherData.weatherType.iconRes),
            contentDescription = null,
            modifier = Modifier.width(20.dp)
        )
        Text(text = "${weatherData.temperatureCelsius}°",
            color = Color.White,
            fontFamily = FontFamily(Font(R.font.sfpro_medium))
        )
        Spacer(modifier = Modifier.width(14.dp))


    }
    
}
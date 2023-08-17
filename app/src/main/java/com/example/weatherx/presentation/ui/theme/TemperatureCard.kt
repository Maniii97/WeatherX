package com.example.weatherx.presentation.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherx.R
import com.example.weatherx.domain.weather.WeatherData
import com.example.weatherx.presentation.WeatherState

@Composable
fun TemperatureCard(
    state : WeatherState,
    modifier: Modifier,

    ) {
    state.weatherInfo?.currentWeatherData?.let { data ->

        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
            ) {
            val temp = data.temperatureCelsius
            val humidity = data.humidity
            val bg = if (temp >= 30.0) {
                RedBg
            }else{
                WhiteBg
            }
            val Hbg = if (humidity > 90){
                RedBg}
            else {Color(0XFF26282b)}

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(180.dp)
                    .background(bg),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "${temp}°C",
                    fontSize = 40.sp,
                    fontFamily = FontFamily(Font(R.font.sfpro_medium)),
                    textAlign = TextAlign.Center,
                    color = if(bg == RedBg){ Color.White }
                    else { Color.Black }
                )
            }
            Spacer(modifier = Modifier.width(20.dp))

            Column {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(40.dp))
                        .height(80.dp)
                        .width(200.dp)
                        .background(Hbg),
                    contentAlignment = Alignment.Center
                ){
                    Text(text = "Humidity  $humidity %",
                        fontSize = 17.sp,
                        fontFamily = FontFamily(Font(R.font.sfpro_medium)),
                        color = Color.White,
                    )

                }
                Spacer(modifier = Modifier.height(20.dp))

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(40.dp))
                        .height(80.dp)
                        .width(200.dp)
                        .background(Color(0xFF26282b)),
                    contentAlignment = Alignment.Center
                ){
                    Text(text = "Wind Speed \n ${data.windSpeed} km/h",
                        fontSize = 17.sp,
                        fontFamily = FontFamily(Font(R.font.sfpro_medium)),
                        color = Color.White,

                    )

                }

            }
        }
    }
}

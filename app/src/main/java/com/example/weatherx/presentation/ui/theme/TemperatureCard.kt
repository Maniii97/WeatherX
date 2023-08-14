package com.example.weatherx.presentation.ui.theme

import android.graphics.drawable.shapes.OvalShape
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherx.R
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
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(180.dp)
                    .background(Color(0xFFedeff2)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "${data.temperatureCelsius}°C",
                    fontSize = 40.sp,
                    fontFamily = FontFamily(Font(R.font.sfpro_medium)),
                    textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.width(20.dp))

            Column() {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(40.dp))
                        .height(80.dp)
                        .width(200.dp)
                        .background(Color(0XFF26282b)),
                    contentAlignment = Alignment.Center
                ){
                    Text(text = "Humidity  ${data.humidity} %",
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.sfpro_medium)),
                        color = Color.White
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
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.sfpro_medium)),
                        color = Color.White,

                    )

                }


            }
        }
    }
}
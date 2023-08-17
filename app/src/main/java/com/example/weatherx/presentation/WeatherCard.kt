package com.example.weatherx.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherx.R
import com.example.weatherx.presentation.ui.theme.TemperatureCard
import java.time.format.DateTimeFormatter

@Composable
fun WeatherCard(
    state : WeatherState,
    backgroundColor : Color,
    modifier: Modifier = Modifier
) {
    state.weatherInfo?.currentWeatherData?.let { data ->
        Card(
            modifier = modifier.padding(28.dp),
            backgroundColor = backgroundColor
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(25.dp))
                Text(
                    text = "Refreshed at ${
                        data.time.format(
                            DateTimeFormatter.ofPattern("HH:mm")
                        )
                    }",
                    fontFamily = FontFamily(Font(R.font.sfpro_medium)),
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(16.dp))
                Image(
                    painter = painterResource(id = data.weatherType.iconRes),
                    contentDescription = null,
                    modifier = Modifier.width(270.dp)
                )
                Spacer(modifier = Modifier.height(35.dp))
                Text(
                    text = data.weatherType.weatherDesc,
                    fontSize = 22.sp,
                    fontFamily = FontFamily(Font(R.font.sfpro_medium)),
                    color = Color.White
                )
            }
        }
        Spacer(modifier = Modifier.height(55.dp))
        LazyColumn(modifier = Modifier.padding(16.dp)) {
            items(1) {
                TemperatureCard(state = state, modifier = Modifier)
                Spacer(modifier = Modifier.height(20.dp))
                HourlyDisplay(state = state)
            }
        }


    }
}

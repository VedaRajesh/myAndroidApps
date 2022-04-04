package com.example.secondscreenui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.secondscreenui.ui.theme.SecondScreenUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SecondScreenUITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SmileScreen()
                }
            }
        }
    }
}

@Composable
fun SmileScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Image(
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            painter = painterResource(id = R.drawable.background),
            modifier = Modifier
                .fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent)
        ) {
            Image(
                painter = painterResource(id = R.drawable.emojis),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .padding(top = 40.dp, start = 10.dp)
                    .height(60.dp)
                    .width(360.dp)
            )


            Image(
                painter = painterResource(id = R.drawable.name_text),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .padding(top = 40.dp, start = 20.dp)
                    .height(60.dp)
                    .width(200.dp)
            )

            Text(
                text = "Created By Rohan.R",
                fontSize = 20.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 520.dp, start = 15.dp)
            )
        }
    }
}

@Preview(showBackground = true,device = Devices.PIXEL_4)
@Composable
fun DefaultPreview() {
    SmileScreen()
}
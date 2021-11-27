package com.example.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Magenta
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.modernnavbar.ui.theme.Orange

@Composable
fun SettingScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Orange),
        contentAlignment = Alignment.Center,

        ){
        Text(
            text = "Setting Screen",
            fontWeight = FontWeight.Bold,
            color = White,
            fontSize = 40.sp
        )
    }
}


@Preview(showBackground = true)
@Composable
fun SettingPre() {
    SettingScreen()
}
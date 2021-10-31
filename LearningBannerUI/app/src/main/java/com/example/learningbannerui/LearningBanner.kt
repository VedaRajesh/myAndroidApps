package com.example.learningbannerui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learningbannerui.ui.theme.OwnBackground

@Composable
fun LearningBanner(click: (() -> Unit)?){
    Card(
        modifier = Modifier
            .height(238.dp)
            .width(160.dp)
            .clickable {
                click?.invoke()
            },
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ){

        }
    }
}

@Preview
@Composable
fun BannerPreview() {
    Column(
        modifier = Modifier
            .background(
                color = OwnBackground
            )
            .fillMaxSize()
    ){
        LearningBanner(click = null)
    }
}
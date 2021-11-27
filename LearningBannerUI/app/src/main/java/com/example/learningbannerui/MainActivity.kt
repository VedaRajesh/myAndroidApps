package com.example.learningbannerui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learningbannerui.ui.theme.OwnBackGround
import com.example.learningbannerui.ui.theme.Purple500
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val systemUiController = rememberSystemUiController()
            var stateForButton = remember {
                mutableStateOf(false)
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(OwnBackGround),
            ) {
                val localContext = LocalContext.current
                LearningBannerUi(
                    bannerModifier = Modifier
                        .padding(top = 180.dp, start = 100.dp),
                    onesClickable = {
//                        // Click able
//                        Toast.makeText(
//                            localContext,
//                            "Hello World My name is Rohan",
//                            Toast.LENGTH_LONG,
//                        ).show()
//                        // Click able is end here
                        stateForButton.value = !stateForButton.value
                    },
                    ratingStars = 2f,
                )

                if (stateForButton.value) {
                    systemUiController.setSystemBarsColor(
                        Color.Green,
                        darkIcons = false,

                    )
                } else {
                    systemUiController.setSystemBarsColor(
                        Color.Magenta,
                        darkIcons = false,
                    )
                }
            }
        }
    }
}
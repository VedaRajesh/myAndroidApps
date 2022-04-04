package com.example.swipableitemslist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.swipableitemslist.ui.theme.CustomGreen
import com.example.swipableitemslist.ui.theme.SwipableItemsListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SwipableItemsListTheme {
                // A surface container using the 'background' color from the them
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        var mutableState = remember {
                            mutableStateOf(true)
                        }
                        SwipAble(CustomGreen, "Rohan.R", mutableState)

                }
            }
        }
    }
}
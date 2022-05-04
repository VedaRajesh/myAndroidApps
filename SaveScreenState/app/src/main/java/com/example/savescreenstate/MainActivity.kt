package com.example.savescreenstate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.savescreenstate.Navigation.ComposeNavigation
import com.example.savescreenstate.ui.theme.SaveScreenStateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SaveScreenStateTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    var screenState = remember {
                        mutableStateOf(true)
                    }
                    ComposeNavigation(navController = navController , state = screenState ){
                        screenState.value = false
                    }
                }
                
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SaveScreenStateTheme {

    }
}
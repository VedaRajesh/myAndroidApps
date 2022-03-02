package com.example.horizantalpager

import android.os.Bundle
import android.util.Log.d
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.horizantalpager.ui.theme.CustomColor
import com.example.horizantalpager.ui.theme.HorizantalPagerTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.example.horizantalpager.R as R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HorizantalPagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    MainScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainScreen() {
    val pagerState = rememberPagerState()
    val listOfScreens = listOf(
        OnBoardingScreen.FirstPagerScreen,
        OnBoardingScreen.SecondPagerScreen,
        OnBoardingScreen.ThirdPagerScreen
    )

    Column(
        modifier = Modifier.fillMaxSize()
    ){
        HorizontalPager(
            count = 3,
            state = pagerState,
            modifier = Modifier
        ) { pager ->
            PagerScreen(onBoardingScreen = listOfScreens[pager])
        }
    }
}

@Composable
fun PagerScreen(
    onBoardingScreen: OnBoardingScreen?
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = onBoardingScreen!!.icons),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 250.dp)
                .size(200.dp)
        )

        Text(
            text = onBoardingScreen.text,
            fontSize = 30.sp,
            color = CustomColor,
            fontWeight = FontWeight.ExtraBold
        )

        Text(
            text = onBoardingScreen.text,
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(top = 20.dp),
        )
    }
}


@Preview
@Composable
fun DefaultPreview() {
    HorizantalPagerTheme {
        PagerScreen(null)
    }
}
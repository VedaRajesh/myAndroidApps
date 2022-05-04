package com.example.savescreenstate.Screens.OnBoardingScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.savescreenstate.R
import com.example.savescreenstate.ui.Julius_Sans_One

@Composable
fun FirstScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier = Modifier
                .padding(top = 80.dp),
            text = "Express VPN",
            fontSize = 33.sp,
            fontWeight = FontWeight.Bold,
            color = Black,
            fontFamily = Julius_Sans_One
        )

        Image(
            painter = painterResource(id = R.drawable.secure_browser),
            contentDescription = "dede",
            modifier = Modifier
                .height(252.dp)
                .width(272.dp)
        )
         Image(
            painter = painterResource(id = R.drawable.card_with_details),
            contentDescription = "dede",
            modifier = Modifier
                .height(341.dp)
                .width(375.dp)
        )
        Row(
            Modifier
                .fillMaxWidth()
                .background(Color.White),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                modifier = Modifier
                    .padding(start = 20.dp),
                text = "Skip",
                fontFamily = Julius_Sans_One,
                fontSize = 20.sp,
                color = Blue,
                textDecoration = TextDecoration.Underline
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DJEIDJOIDJEODJOIDJOIOIN() {
    FirstScreen()
}
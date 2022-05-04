package com.example.savescreenstate.Screens.OnBoardingScreens

import android.text.Layout
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.savescreenstate.R
import com.example.savescreenstate.ui.Julius_Sans_One

@Composable
fun SecondScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Layout.Alignment.CenterHorizontally,
    ) {

        Text(
            modifier = Modifier
                .padding(top = 70.dp),
            text = "Satisfied \nCustomers",
            textAlign = TextAlign.Center,
            fontSize = 33.sp,
            fontWeight = FontWeight.Bold,
            color = Black,
            fontFamily = Julius_Sans_One
        )
        Spacer(modifier = Modifier.padding(bottom = 22.dp))
        Image(
            painter = painterResource(R.drawable.happy_customers),
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
    }
}
@Preview(showBackground = true)
@Composable
fun OIDJEODJOIDJOIOIN() {
    SecondScreen()
}
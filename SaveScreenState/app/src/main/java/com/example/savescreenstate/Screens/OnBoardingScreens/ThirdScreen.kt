package com.example.savescreenstate.Screens.OnBoardingScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.savescreenstate.R
import com.example.savescreenstate.ui.Julius_Sans_One

@Composable
fun ThirdScreen(onCLick:()-> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            modifier = Modifier
                .padding(top = 30.dp),
            text = "Developed \nApplication",
            textAlign = TextAlign.Center,
            fontSize = 33.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontFamily = Julius_Sans_One
        )
        Spacer(modifier = Modifier.padding(bottom = 22.dp))
        Image(
            painter = painterResource(R.drawable.developed_application),
            contentDescription = "dede",
            modifier = Modifier
                .height(253.dp)
                .width(279.dp)
        )


        Button(
            onClick = { onCLick.invoke() },
            modifier = Modifier
                .padding(top = 10.dp)
        ) {
            Text(text = "Get Started",fontFamily = Julius_Sans_One,fontSize = 22.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DJIDEI() {
    ThirdScreen(){

    }
}
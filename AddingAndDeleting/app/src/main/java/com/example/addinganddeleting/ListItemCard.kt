package com.example.addinganddeleting

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.addinganddeleting.Navigation.NavItems

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ListItemCard(firstName : String = "Rohan",lastName : String = "Rohan",onClick : () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(White)
            .padding(start = 10.dp, end = 10.dp, top = 10.dp),
        onClick = onClick
    ) {
        // First Name & Last Name
        Column(
            modifier = Modifier
                .background(White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "$firstName.$lastName",
                fontSize = 20.sp,
                color = Black,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                softWrap = true,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(bottom = 8.dp)
            )
            Divider(modifier = Modifier.padding(bottom = 7.dp),color = Black,thickness = 1.dp)
        }
    }
}

@Preview
@Composable
fun MlistItemCard() {
//    ListItemCard("Rohan","Rajesh", rememberNavController())
}
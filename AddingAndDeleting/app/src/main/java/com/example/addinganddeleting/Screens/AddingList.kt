package com.example.addinganddeleting.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.TextFieldDefaults.textFieldColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.addinganddeleting.R
import com.example.addinganddeleting.ui.theme.Purple500

@Composable
fun AddingItemScreen(onClick : () -> Unit) {
    var firstName = remember {
        mutableStateOf("")
    }
    var lastName = remember {
        mutableStateOf("")
    }
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Icon(
                        Icons.Default.ArrowBack, contentDescription = null,
                        modifier = Modifier
                            .padding(top = 9.dp)
                            .size(40.dp)
                    )

                    // Text
                    Text(
                        text = "Adding Item Screen", fontSize = 25.sp, modifier = Modifier
                            .padding(top = 10.dp, start = 55.dp)
                    )
                }
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Text Field FIRST NAME
            Image(painter = painterResource(id = R.drawable.data_illustrator), contentDescription = null, modifier = Modifier
                .padding(bottom = 100.dp)
                .width(200.dp)
                .height(150.dp),contentScale = ContentScale.FillBounds)
            TextField(
                value = firstName.value,
                onValueChange = {
                    firstName.value = it
                },
                modifier = Modifier
                    .clip(RoundedCornerShape(CornerSize(15.dp))),
                shape = RoundedCornerShape(CornerSize(15.dp)),
                colors = textFieldColors(
                    backgroundColor = Purple500,
                    unfocusedLabelColor = Color.White,
                    focusedLabelColor = Color.White,
                    textColor = Color.White
                ),
                label = {
                    Text(text = "Last Name")
                },
            )

            Spacer(modifier = Modifier.padding(11.dp))

            TextField(
                value = lastName.value,
                onValueChange = {
                    lastName.value = it
                },
                label = {
                    Text(text = "Last Name")
                },
                modifier = Modifier
                    .clip(RoundedCornerShape(CornerSize(15.dp))),
                shape = RoundedCornerShape(CornerSize(15.dp)),
                colors = textFieldColors(
                    backgroundColor = Purple500,
                    unfocusedLabelColor = Color.White,
                    focusedLabelColor = Color.White,
                    textColor = Color.White
                    )
            )
            Spacer(modifier = Modifier.padding(11.dp))
            Button(onClick = {
                onClick.invoke()
            },
            modifier = Modifier
                .height(50.dp)
                .width(110.dp)) {
                Text(text = "Add",fontSize = 20.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddingScreenPrev() {
    AddingItemScreen(){

    }
}
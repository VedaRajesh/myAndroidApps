package com.example.roomdatabaseproject.Screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.TextFieldDefaults.outlinedTextFieldColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.roomdatabaseproject.RoomDatabase.RoomEntity
import com.example.roomdatabaseproject.RoomDataViewModel


@Composable
fun AddListScreen(navController: NavController,noteViewModel : RoomDataViewModel) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .fillMaxWidth(),
                backgroundColor = Green
            ) {
                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = 3.dp)
                        .clickable {
                            navController.navigateUp()
                        }
                        .size(34.dp),
                    tint = Color.Black
                )
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val name = remember {
                mutableStateOf("")
            }

            val aboutYourSelf = remember {
                mutableStateOf("")
            }

            var age = remember { mutableStateOf("") }

            val contex = LocalContext.current
            Spacer(modifier = Modifier.padding(top = 170.dp))
            OutlinedTextField(
                value = name.value,
                onValueChange = {
                    name.value = it
                },
                modifier = Modifier
                    .padding(horizontal = 30.dp),
                maxLines = 2,
                colors = outlinedTextFieldColors(
                    backgroundColor = White,
                    disabledBorderColor = Gray,
                    focusedBorderColor = Green,
                    textColor = Black,
                    disabledTextColor = Gray,
                    cursorColor = Green,
                    unfocusedLabelColor = Gray,
                    focusedLabelColor = Black
                ),
                label = {
                    Text(text = "Name", fontSize = 18.sp)
                }
            )
            Spacer(modifier = Modifier.padding(10.dp))
            OutlinedTextField(
                value = aboutYourSelf.value,
                onValueChange = {
                    aboutYourSelf.value = it
                },
                modifier = Modifier
                    .padding(start = 30.dp, end = 30.dp),
                maxLines = 2,
                colors = outlinedTextFieldColors(
                    backgroundColor = White,
                    disabledBorderColor = Gray,
                    focusedBorderColor = Green,
                    textColor = Black,
                    disabledTextColor = Gray,
                    cursorColor = Green,
                    unfocusedLabelColor = Gray,
                    focusedLabelColor = Black
                ),
                label = {
                    Text(text = "Your Short Resume", fontSize = 18.sp)
                }
            )
            Spacer(modifier = Modifier.padding(10.dp))

            OutlinedTextField(
                value = age.value,
                onValueChange = {
                    age.value = it
                },
                modifier = Modifier
                    .height(60.dp)
                    .width(120.dp)
                    .padding(start = 30.dp, end = 30.dp),
                maxLines = 2,
                colors = outlinedTextFieldColors(
                    backgroundColor = White,
                    disabledBorderColor = Gray,
                    focusedBorderColor = Green,
                    textColor = Black,
                    disabledTextColor = Gray,
                    cursorColor = Green,
                    unfocusedLabelColor = Gray,
                    focusedLabelColor = Black
                ),
                label = {
                    Text(text = "Age", fontSize = 17.sp)
                },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            )
            Spacer(modifier = Modifier.padding(30.dp))


            Button(
                onClick = {
                    if (name.value.isEmpty()) {
                        Toast.makeText(contex, "Name Field Is Empty", Toast.LENGTH_LONG).show()
                    } else if (aboutYourSelf.value.isEmpty()) {
                        Toast.makeText(contex, "Please Enter Your Short Resume", Toast.LENGTH_LONG)
                            .show()
                    } else if (age.value.isEmpty()) {
                        Toast.makeText(contex, "Please Fill Your Age", Toast.LENGTH_LONG).show()
                    } else {
                        try {
                            myApplication(
                                viewModel = noteViewModel,
                                age = age.value,
                                name = name.value,
                                aboutYourSelf = aboutYourSelf.value
                            )
                            name.value = ""
                            aboutYourSelf.value = ""
                            age.value = ""

                            navController.popBackStack()
                            navController.navigateUp()

                        } catch (e: Exception) {
                            Log.d("Error Add Data ", e.toString())
                        }
                    }
                }, colors = ButtonDefaults.buttonColors(
                    backgroundColor = Green
                ), modifier = Modifier
                    .clip(RoundedCornerShape(corner = CornerSize(40.dp)))
                    .height(50.dp)
                    .width(160.dp),
                shape = RoundedCornerShape(corner = CornerSize(40.dp))
            ) {
                Text(
                    text = "Save Data",
                    color = Black,
                    fontSize = 18.sp
                )
            }
        }
    }
}

fun myApplication(viewModel: RoomDataViewModel, age: String, name: String, aboutYourSelf: String) {

    viewModel.addNotes(RoomEntity(age = age, firstName = name, aboutUserSelf = aboutYourSelf))

}

package com.example.noteapp.Components

import android.widget.Toast
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TextFieldDefaults.textFieldColors
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.ImeOptions
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import java.lang.reflect.Modifier

@Composable
fun CustomTextField(
    text : MutableState<String>,
    label : String,
    modifier : androidx.compose.ui.Modifier
) {
    val contex = LocalContext.current
    TextField(
        value = text.value,
        onValueChange = {
               text.value = it

        },
        label = {
            Text(text = label,color = Color.Black,fontWeight = FontWeight.Bold)
        },
        modifier = modifier,
        colors = textFieldColors(
            backgroundColor = Color.White,
        ),
        maxLines = 1,

    )
}

@Preview(showBackground = true)
@Composable
fun DEDEOJEOJDEOJEODJEPODJe() {
    var state = remember{
        mutableStateOf("")
    }
    CustomTextField(text = state, label = "Hello",modifier = androidx.compose.ui.Modifier)
}
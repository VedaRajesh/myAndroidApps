package com.example.noteapp.Components

import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.noteapp.ui.theme.Shapes
import java.lang.reflect.Modifier

@Composable
fun CustomButton(onClick : () -> Unit,modifier : androidx.compose.ui.Modifier,insideButton : () -> Unit) {
    Button(
        onClick = onClick,
        shape = Shapes.medium.copy(all = CornerSize(10.dp)),
        modifier = modifier
    ){
        insideButton.invoke()
        Text(text = "SAVE",color = Color.White)
    }
}
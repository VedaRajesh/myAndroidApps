package com.example.learningbannerui.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)
val OwnBackground = Color(0xFF1162CA)
val VeryLightGray = Color(0xD3DFE3E6)
val OwnBackGround = Color(0xFFEE98FB)

val Color.ownBackground
     @Composable
     get() = OwnBackground

val Color.veryLightGray
     @Composable
     get() = VeryLightGray

val Color.ownBackGround
     @Composable
     get() = OwnBackGround
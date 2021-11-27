package com.example.modernnavbar.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)
val Orange = Color(0xFFFF9800)
val BottomBarColor = Color(0xFF424947)
val TopAppBarColor = Color(0xFFFFBD45)

val Color.orange : Color
@Composable
    get() = Orange

val Color.bottomBarColor : Color
    @Composable
    get() = BottomBarColor

val Color.topAppBarCOlor : Color
    @Composable
    get() = TopAppBarColor

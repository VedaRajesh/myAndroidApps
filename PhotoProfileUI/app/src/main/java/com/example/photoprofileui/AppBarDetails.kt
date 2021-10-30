package com.example.photoprofileui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.photoprofileui.ui.theme.Purple200

@Composable
fun AppBarDetails(navigation: NavHostController?) {
    TopAppBar(
        modifier = Modifier.background(
            color = Purple200,
        ),

        ) {

        Icon(Icons.Default.ArrowBack,
        contentDescription = "Back",
        modifier = Modifier.padding(start = 9.dp)
            .clickable {
                navigation?.navigateUp()
            }
        )

        Text(
            text = "User Datails Screen",
            color = Color.White,
            modifier = Modifier.padding(start = 90.dp),
            fontSize = 20.sp // dddddd
        )

    }
}

@Preview
@Composable
fun DefaultPrev() {
    AppBarDetails(navigation = null)

}

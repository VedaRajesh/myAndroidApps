package com.example.addinganddeleting.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.addinganddeleting.ADData
import com.example.addinganddeleting.ListItemCard
import com.example.addinganddeleting.Navigation.NavItems

@Composable
fun ListScreen(list: List<ADData>, navController: NavController) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .fillMaxWidth(),
                ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {
                    Text(
                        text = "List Screen",
                        color = White,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(start = 140.dp, top = 3.dp)
                    )

                    Icon(
                        Icons.Default.Add,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(start = 90.dp)
                            .size(35.dp)
                            .clickable {
                                navController.navigate(NavItems.AddScreen.route)
                                navController.popBackStack()
                            },
                    )
                }
            }
        }
    ) {
        LazyColumn {
            items(list) { key ->
                ListItemCard(
                    firstName = key.name,
                    lastName = key.LastName
                ) {
                    // NOT Yet IMPLEMENTED
                }
            }
        }
    }
}

@Preview
@Composable
fun DEDIEIDJEIDJEDIOEJDIEJdiListScreen() {
    ListScreen(emptyList(), rememberNavController())
}
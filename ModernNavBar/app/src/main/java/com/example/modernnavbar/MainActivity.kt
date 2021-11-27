package com.example.modernnavbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.Screens.HomeScreen
import com.example.Screens.SmileScreen
import com.example.Screens.SettingScreen
import com.example.modernnavbar.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ModernNavBarTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(
                            onClick = {
                                navController.navigate(it.rout)
                            },
                            navController = navController,
                            item = listOf(
                                BottomBarItems(
                                    title = "Home",
                                    rout = "home",
                                    icons = painterResource(id = R.drawable.ic_baseline_home_24)
                                ),
                                BottomBarItems(
                                    title = "Smile",
                                    rout = "smile",
                                    icons = painterResource(id = R.drawable.ic_baseline_tag_faces_24)
                                ),
                                BottomBarItems(
                                    title = "Setting",
                                    rout = "setting",
                                    icons = painterResource(id = R.drawable.ic_baseline_settings_24)
                                )
                            )
                        )
                    }
                ) {
                    Navigation(navController = navController)
                    // System ui colors

                }
            }
        }
    }
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen()
        }
        composable("smile") {
            SmileScreen()
        }
        composable("setting") {
            SettingScreen()
        }
    }
}

@Composable
fun BottomNavigationBar(
    onClick: (BottomBarItems) -> Unit,
    navController: NavHostController,
    item: List<BottomBarItems>,
) {
    val BackStackEntry = navController.currentBackStackEntryAsState()

    BottomNavigation(
        modifier = Modifier
            .fillMaxWidth()
            .graphicsLayer {
                clip = true
                shape = RoundedCornerShape(15.dp)
            },
        backgroundColor = BottomBarColor,
        elevation = 6.dp,
    ) {
        item.forEach { items ->
            val selection = items.rout == BackStackEntry.value?.destination?.route

            BottomNavigationItem(
                selected = selection,
                onClick = { onClick(items) },
                selectedContentColor = Orange,
                unselectedContentColor = Teal200,
                icon = {
                    Icon(
                        items.icons,
                        contentDescription = null,
                        Modifier.padding(start = 7.dp)
                    )

                    if (selection) {
                        Row(
                            modifier = Modifier
                                .padding(top = 22.dp),
                        ) {
                            Text(
                                text = items.title,
                                textAlign = TextAlign.Center,
                                fontSize = 14.sp,
                                modifier = Modifier
                            )
                        }
                    }
                },
            )
        }
    }
}
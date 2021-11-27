package com.example.jcbottomnav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.jcbottomnav.ui.theme.JCBottomNavTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JCBottomNavTheme {
                val navController: NavController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(items = listOf(
                            BottonBarItems(
                                "home",
                                "Home",
                                icon = painterResource(id = R.drawable.ic_baseline_home_24)
                            ),
                            BottonBarItems(
                                "setting",
                                "Setting",
                                icon = painterResource(id = R.drawable.ic_baseline_settings_24)
                            ),
                            BottonBarItems(
                                "profile",
                                "Profile",
                                icon = painterResource(id = R.drawable.ic_baseline_profile)

                            )
                        ),
                            navController = navController as NavHostController,
                            modifier = Modifier,
                            onItemClickListener = {
                                navController.navigate(it.rout)
                            })
                    }
                ) {
                    Navigations(navHostController = navController as NavHostController)
                }
            }
        }
    }
}

@Composable
fun Navigations(navHostController: NavHostController) {

    NavHost(navController = navHostController, startDestination = "home") {
        composable("home") {
            HomeScreen()
        }
        composable("setting") {
            SettingScreen()
        }
        composable("profile") {
            ProfileScreen()
        }
    }

}

@Composable
fun BottomNavigationBar(
    items: List<BottonBarItems>,
    navController: NavHostController,
    modifier: Modifier,
    onItemClickListener: (BottonBarItems) -> Unit,
) {
    val backStackEntity = navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = modifier,
        backgroundColor = Color.DarkGray,
        elevation = 10.dp,
    ) {
        items.forEach { item ->
            val selection = item.rout == backStackEntity.value?.destination?.route


            BottomNavigationItem(
                selected = selection,
                onClick = { onItemClickListener(item) },
                selectedContentColor = Green,
                unselectedContentColor = Gray,
                icon = {
                    Icon(item.icon, contentDescription = item.title)
                    Icon(item.icon, contentDescription = item.title)
                    Icon(item.icon, contentDescription = item.title)
                }
            )
        }
    }
}

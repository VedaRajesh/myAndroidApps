package com.example.addinganddeleting.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.addinganddeleting.ADData
import com.example.addinganddeleting.Screens.AddingItemScreen
import com.example.addinganddeleting.Screens.AddingScreenPrev
import com.example.addinganddeleting.Screens.ListScreen
import java.security.acl.LastOwnerException

@Composable
fun NavigationGraph(
    navController: NavHostController,
    list: List<ADData>,
    onClick: () -> Unit,
) {
    NavHost(navController = navController, startDestination = NavItems.ListScreen.route){
        composable(NavItems.ListScreen.route){
            // Home Screen Yet To Be implemented
            ListScreen(list = list,navController = navController)
        }
        composable(NavItems.AddScreen.route){
                AddingItemScreen(
                    onClick = onClick
                )
        }
    }
}
package com.example.roomdatabaseproject.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.roomdatabaseproject.Constants.NavItems
import com.example.roomdatabaseproject.RoomDataViewModel
import com.example.roomdatabaseproject.Screens.AddListScreen
import com.example.roomdatabaseproject.Screens.ListScreen

@Composable
fun RoomNavigation(navController: NavHostController,noteViewModel : RoomDataViewModel) {
    NavHost(navController = navController, startDestination = NavItems.ListScreen.route) {
        composable(route = NavItems.ListScreen.route) {
            ListScreen(navController = navController,noteViewModel)
        }
        composable(route = NavItems.AddListScreen.route) {
            AddListScreen(navController = navController,noteViewModel)
        }
    }
}
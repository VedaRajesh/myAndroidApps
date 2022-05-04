package com.example.savescreenstate.Navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.savescreenstate.Screens.MainScreenS
import com.example.savescreenstate.Screens.OnBoardingScreen

@SuppressLint("UnrememberedMutableState")
@Composable
fun ComposeNavigation(navController: NavHostController,state : MutableState<Boolean>,buttonOnClick : () -> Unit) {

    NavHost(navController = navController , startDestination = if (state.value) "on_boarding_screen" else "main_screen"){
        composable("on_boarding_screen"){
            OnBoardingScreen(buttonOnClick,state)
        }

        composable("main_screen"){
            MainScreenS()
        }
    }
}
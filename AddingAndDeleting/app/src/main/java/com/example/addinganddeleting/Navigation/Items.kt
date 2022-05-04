package com.example.addinganddeleting.Navigation

sealed class NavItems(
    val route : String,
    val title : String
){
    object ListScreen : NavItems(
        route = "main_screen",
        title = "MainScreen"
    )
    object AddScreen : NavItems(
        route = "main_screen",
        title = "MainScreen"
    )
}
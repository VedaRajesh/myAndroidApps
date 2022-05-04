package com.example.roomdatabaseproject.Constants

sealed class NavItems(
    val route : String,
    val title: String
){
    object ListScreen : NavItems(
        route = "list_screen",
        title = "List Screen"
    )

    object AddListScreen : NavItems(
        route = "addList_screen",
        title = "Add List Screen"
    )
}
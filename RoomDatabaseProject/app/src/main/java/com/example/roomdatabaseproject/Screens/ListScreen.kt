package com.example.roomdatabaseproject.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.roomdatabaseproject.Components.CardItem
import com.example.roomdatabaseproject.Constants.NavItems
import com.example.roomdatabaseproject.RoomDataViewModel

@Composable
fun ListScreen(navController: NavController, viewModel: RoomDataViewModel) {
    val notesList = viewModel.noteList.collectAsState().value


    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        backgroundColor = Color.White,
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .fillMaxWidth(),
                backgroundColor = Green
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "List Screen",
                        color = Color.Black,
                        fontSize = 25.sp,
                        modifier = Modifier,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                modifier = Modifier
                    .size(70.dp),
                onClick = { navController.navigate(NavItems.AddListScreen.route) },
                backgroundColor = Green,
                text = {
                    Icon(
                        Icons.Default.Add, contentDescription = null, modifier = Modifier
                            .size(70.dp)
                    )
                }
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .background(White)
        ) {
            items(notesList) { efe ->
                CardItem(note = efe){
                    viewModel.removeNote(it)
                }
            }
        }
    }
}

//@Preview
//@Composable
//fun IJDEOJDOIioJOJDEodh() {
//    val nav = rememberNavController()
//    ListScreen(
//        nav,
//        RoomDataViewModel()
//    )
//}

@Preview
@Composable
fun ALdiJEIDNEODEN() {
}
//    AlertDialog(firstName = , lastName = , age = )}
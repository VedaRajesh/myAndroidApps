package com.example.noteapp.Screens

import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.noteapp.Components.CardRow
import com.example.noteapp.Components.CustomButton
import com.example.noteapp.Components.CustomTextField
import com.example.noteapppart2.Model.Note
import com.example.noteapppart2.ui.theme.Purple700
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainScreen(
    notes: List<Note>,
    onNoteAdded: (Note) -> Unit,
    onNoteRemoved: (Note) -> Unit
) {
    Column(
        modifier = Modifier.padding(6.dp)
    ) {
        TopAppBar(
            modifier = Modifier
                .fillMaxWidth(),
            backgroundColor = Color.Gray,
            actions = {
                Icon(
                    Icons.Default.Home,
                    contentDescription = null,
                    modifier = Modifier.size(40.dp)
                )
            },
            title = {
                Text(
                    text = "Note App",
                    color = Color.Black,
                    fontSize = 23.sp
                )
            }
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var Note = remember {
                mutableStateOf("")
            }

            var noteDiscription = remember {
                mutableStateOf("")
            }
            // Note For First Name
            CustomTextField(
                text = Note,
                label = "Write A Note",
                modifier = Modifier
                    .background(White)
                    .padding(start = 30.dp, end = 30.dp, top = 26.dp)
            )
            // TextField For Last Name
            CustomTextField(
                text = noteDiscription,
                label = "Discription",
                modifier = Modifier
                    .background(White)
                    .padding(start = 30.dp, end = 30.dp, top = 20.dp)

            )
            // Button
            val courutinesScope = rememberCoroutineScope()
            var progressState = remember {
                mutableStateOf(false)
            }
            val contex = LocalContext.current
            CustomButton(modifier = Modifier.padding(top = 14.dp, bottom = 10.dp), onClick = {
                if (Note.value.isNotEmpty()) {
                    courutinesScope.launch {
                        progressState.value = true
                        delay(2000)
                        progressState.value = false
                        onNoteAdded(
                            Note(
                                note = Note.value,
                                discription = noteDiscription.value
                            )
                        )
                        Note.value = ""
                        noteDiscription.value = ""
                        Log.d("Main Screen", "Text Fields Are Not Empty")

                    }
                } else {
                    Toast.makeText(contex, "Please Fill the TextFiled First", Toast.LENGTH_LONG)
                        .show()
                    Log.d("Main Screen", "Text Fields Are Empty")
                }

            },
                insideButton = {}) // wast command
            if (progressState.value) {
                CircularProgressIndicator(
                    modifier = Modifier,
                    color = Purple700,
                    strokeWidth = 1.dp
                )

            }
            Divider(
                modifier = Modifier
                    .padding(bottom = 2.dp, top = 3.dp),
                color = Black,
                thickness = 1.dp
            )

            LazyColumn(
                modifier = Modifier.padding(6.dp)
            ) {
                items(notes) { notesKey ->
                    CardRow(items = notesKey) {
                        onNoteRemoved(notesKey)
                    }
                    Spacer(modifier = Modifier.padding(10.dp))
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun DEDEDJEIJ() {
    MainScreen(emptyList(), {}, {})
}
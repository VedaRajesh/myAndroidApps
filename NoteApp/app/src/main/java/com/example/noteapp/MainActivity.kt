package com.example.noteapp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.noteapp.Data.ListDataSource
import com.example.noteapp.Model.Note
import com.example.noteapp.Screens.MainScreen
import com.example.noteapp.Screens.NoteViewModel
import com.example.noteapp.ui.theme.NoteAppTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteAppTheme {
                val noteMainState = remember {
                    mutableStateListOf<Note>()
                }
                val notesViewModel : NoteViewModel by viewModels()
                MyApp(viewModel = notesViewModel)
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MyApp(viewModel : NoteViewModel) {
    val notesList = viewModel.getAllNotes()
    MainScreen(
        notes = notesList,
        onNoteAdded = {
            viewModel.addNote(it)
        },
        onNoteRemoved = {
            viewModel.removeNote(it)
        }
    )
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

}
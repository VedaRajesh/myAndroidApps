package com.example.noteapp.Screens

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.noteapp.Model.Note

class NoteViewModel : ViewModel(){
    private val notesList = mutableStateListOf<Note>()
    fun addNote(notes : Note){
        notesList.add(notes)
    }
    fun removeNote(notes: Note){
        notesList.remove(notes)
    }

    fun getAllNotes() : List<Note>{
        return notesList
    }
}
package com.example.noteapp.Screens

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp.Model.Note
import com.example.noteapppart2.Repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val repository: NoteRepository) : ViewModel(){
//    private val notesList = mutableStateListOf<Note>()

    val _notesList = MutableStateFlow<List<Note>>(emptyList())
    val notesList = _notesList.asStateFlow()


//    fun addNote(notes : Note){
//        notesList.add(notes)
//    }
//    fun removeNote(notes: Note){
//        notesList.remove(notes)
//    }
//
//    fun getAllNotes() : List<Note>{
//        return notesList
//    }
    init {
        viewModelScope.launch(Dispatchers.IO){
            repository.getAllNote().distinctUntilChanged()
                .collect{ listOfNotes ->
                    if (listOfNotes.isNullOrEmpty()){
                        Log.d("Empty", "Empty List")
                    }else{
                        _notesList.value = listOfNotes
                    }
                }
        }
    }

    fun addNote(notes : Note) = viewModelScope.launch { repository.addNote(notes) }
    fun updateNote(note : Note) = viewModelScope.launch { repository.updateNote(note) }
    fun removeNote(note : Note) = viewModelScope.launch { repository.deleteNote(note)}

}
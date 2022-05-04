package com.example.roomdatabaseproject

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdatabaseproject.RoomDatabase.Ripo.DatabaseRepository
import com.example.roomdatabaseproject.RoomDatabase.RoomEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RoomDataViewModel @Inject constructor(private val repository: DatabaseRepository) :
    ViewModel() {

    private val _noteList = MutableStateFlow<List<RoomEntity>>(emptyList())
    val noteList = _noteList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllData().distinctUntilChanged()
                .collect { listOfNotes ->
                    if (listOfNotes.isNullOrEmpty()) {
                        Log.d("Empty", ": Empty list")
                    } else {
                        _noteList.value = listOfNotes
                    }

                }

        }
    }

    fun addNotes(notes: RoomEntity) {
        viewModelScope.launch {
            repository.addData(notes)
        }

    }

    fun removeNote(note: RoomEntity) = viewModelScope.launch { repository.deleteData(note) }

}
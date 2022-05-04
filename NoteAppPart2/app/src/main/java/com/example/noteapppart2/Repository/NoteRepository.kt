package com.example.noteapppart2.Repository

import com.example.noteapp.Data.RoomDatabaseDao
import com.example.noteapppart2.Model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class NoteRepository @Inject constructor(private val noteDatabaseDao : RoomDatabaseDao){
    suspend fun addNote(note : Note) = noteDatabaseDao.insertNote(note)
    suspend fun updateNote(note: Note) = noteDatabaseDao.update(note)
    suspend fun deleteNote(note:Note) = noteDatabaseDao.delete(note)
    suspend fun deleteAllNotes() = noteDatabaseDao.deleteAll()
    fun getAllNote() :  Flow<List<Note>> = noteDatabaseDao.getAllNotes().flowOn(
        Dispatchers.IO
    ).conflate()
}
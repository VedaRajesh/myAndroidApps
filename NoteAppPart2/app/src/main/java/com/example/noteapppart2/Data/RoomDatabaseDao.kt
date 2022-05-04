package com.example.noteapp.Data

import androidx.room.*
import com.example.noteapppart2.Model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface RoomDatabaseDao {

    @Query("SELECT * FROM notes_tbl")
    fun getAllNotes() : Flow<List<Note>>

    @Query("SELECT * FROM notes_tbl where id = :id")
    suspend fun getNotesById(id:Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note:Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(note:Note)

    @Query("DELETE from notes_tbl")
    suspend fun deleteAll()

    @Delete
    suspend fun delete(note:Note)

}
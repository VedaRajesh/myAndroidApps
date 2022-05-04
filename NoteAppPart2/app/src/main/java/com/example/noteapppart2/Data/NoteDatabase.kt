package com.example.noteapp.Data

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.noteapp.Utils.DateConverter
import com.example.noteapp.Utils.UUIdConverter
import com.example.noteapppart2.Model.Note

@RequiresApi(Build.VERSION_CODES.O)
@Database(entities =[Note::class],version = 1,exportSchema = true)
@TypeConverters(DateConverter::class, UUIdConverter::class)
abstract class NoteDatabase : RoomDatabase(){
    abstract fun noteDao():RoomDatabaseDao
}
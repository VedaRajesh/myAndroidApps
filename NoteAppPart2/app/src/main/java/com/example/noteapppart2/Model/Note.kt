package com.example.noteapppart2.Model

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime
import java.util.*
@RequiresApi(Build.VERSION_CODES.O)
@Entity(tableName = "notes_tbl")
data class Note(

    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,

    @ColumnInfo(name = "note_title")
    val note : String,

    @ColumnInfo(name = "note_description")
    val discription : String,
)
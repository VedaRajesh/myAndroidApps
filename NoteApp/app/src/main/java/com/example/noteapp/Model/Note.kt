package com.example.noteapp.Model

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
data class Note  constructor(
    val id : UUID = UUID.randomUUID(),
    val note : String,
    val discription : String,
    val entryDate : LocalDateTime = LocalDateTime.now()
)
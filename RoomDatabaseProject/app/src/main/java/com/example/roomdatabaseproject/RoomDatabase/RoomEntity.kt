package com.example.roomdatabaseproject.RoomDatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "room_table")
data class RoomEntity(

    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,

    val firstName : String,

    val aboutUserSelf : String,

    val age : String
)

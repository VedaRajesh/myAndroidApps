package com.example.roomdatabaseproject.RoomDatabase

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RoomEntity :: class],exportSchema = false , version = 1)
abstract class RoomDatabaseOriginal : RoomDatabase(){
    abstract fun dataDao():RoomDao
}
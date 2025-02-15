package com.example.noteapp.Utils

import androidx.room.TypeConverter
import java.util.*


class UUIdConverter {

    @TypeConverter
    fun fromUUID(uuid: UUID):String?{
        return uuid.toString()
    }

    @TypeConverter
    fun uuidFromString(string: String):UUID?{
        return UUID.fromString(string)
    }
}
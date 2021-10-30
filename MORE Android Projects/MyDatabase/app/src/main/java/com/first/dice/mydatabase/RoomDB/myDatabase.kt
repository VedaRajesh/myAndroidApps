package com.first.dice.mydatabase.RoomDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(UserEntity :: class), version = 1 , exportSchema = false)
abstract class myDatabase : RoomDatabase(){

    abstract fun userDao() : Dao

    companion object {

        @Volatile
        private var INSTANCE : myDatabase? = null

            fun getDatabase(context: Context): myDatabase {
                // if the INSTANCE is not null, then return it,
                // if it is, then create the database
                return INSTANCE ?: synchronized(this) {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        myDatabase::class.java,
                        "word_database"
                    ).build()
                    INSTANCE = instance
                    // return instance
                    instance
                }
            }
        }
    }
package com.first.dice.favoritedish.model.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.first.dice.favoritedish.model.FavDishEntity

@Database(entities = arrayOf(FavDishEntity::class), version = 1, exportSchema = false)
 abstract class Database : RoomDatabase() {

    companion object {
        @Volatile
        private var INSTANCE: RoomDatabase? = null

        public fun getDatabase(context: Context): RoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RoomDatabase::class.java,
                    "word_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
        }
      }
   }
 }

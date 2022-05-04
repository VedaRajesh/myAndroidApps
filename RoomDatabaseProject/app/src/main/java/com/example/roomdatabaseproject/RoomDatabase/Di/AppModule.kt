package com.example.roomdatabaseproject.RoomDatabase.Di

import android.content.Context
import androidx.room.Room
import com.example.roomdatabaseproject.RoomDatabase.RoomDao
import com.example.roomdatabaseproject.RoomDatabase.RoomDatabaseOriginal
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule{

    @Singleton
    @Provides
    fun provideNotesDao(roomDatabase : RoomDatabaseOriginal) : RoomDao = roomDatabase.dataDao()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext contex : Context) : RoomDatabaseOriginal
    = Room.databaseBuilder(
        contex,
        RoomDatabaseOriginal :: class.java,
        "room_database")
        .fallbackToDestructiveMigration()
        .build()
}
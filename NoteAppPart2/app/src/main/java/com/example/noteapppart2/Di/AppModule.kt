package com.example.noteapppart2.Di

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Room
import com.example.noteapp.Data.NoteDatabase
import com.example.noteapp.Data.RoomDatabaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @RequiresApi(Build.VERSION_CODES.O)
    @Singleton
    @Provides
    fun provideNoteDao(noteDatabase: NoteDatabase): RoomDatabaseDao = noteDatabase.noteDao()

    @RequiresApi(Build.VERSION_CODES.O)
    @Singleton
    @Provides
    fun provideNoteDatabase(@ApplicationContext contex: Context): NoteDatabase = Room
        .databaseBuilder(
            contex,
            NoteDatabase::class.java,
            "note_database"
        )
        .fallbackToDestructiveMigration()
        .build()
}
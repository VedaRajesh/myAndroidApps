package com.first.dice.mydatabase.RoomDB

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao


@Dao
interface Dao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user : UserEntity)

    @Query("SELECT * FROM my_table ORDER By id ASC")
    fun realAllData() : LiveData<List<UserEntity>>

    @Delete
    suspend fun delectUser(user: UserEntity)

    @Query("DELETE FROM my_table ")
    suspend fun delectAll()

    @Update
    suspend fun updateUser(user : UserEntity)
}
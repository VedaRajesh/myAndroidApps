package com.example.roomdatabaseproject.RoomDatabase

import android.provider.ContactsContract
import androidx.room.*
import java.util.concurrent.Flow

@Dao
interface RoomDao{

    @Query("SELECT * From room_table")
    fun getAllData(): kotlinx.coroutines.flow.Flow<List<RoomEntity>>

    @Query("SELECT * FROM room_table WHERE id = :id")
    suspend fun getDataById(id : String) : RoomEntity

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addData(data : RoomEntity)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateData(data : RoomEntity)

    @Delete
    suspend fun deleteData(data : RoomEntity)

    @Query("DELETE FROM room_table")
    suspend fun deleteAll()
}
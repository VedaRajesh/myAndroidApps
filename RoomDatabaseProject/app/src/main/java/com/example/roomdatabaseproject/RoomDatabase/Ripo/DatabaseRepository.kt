package com.example.roomdatabaseproject.RoomDatabase.Ripo

import com.example.roomdatabaseproject.RoomDatabase.RoomDao
import com.example.roomdatabaseproject.RoomDatabase.RoomEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class DatabaseRepository @Inject constructor(private val databaseDao : RoomDao) {
    suspend fun addData(data : RoomEntity) = databaseDao.addData(data)

    suspend fun updateData(data : RoomEntity) = databaseDao.updateData(data)

    suspend fun deleteData(data : RoomEntity) = databaseDao.deleteData(data)

    suspend fun deleteAllData() = databaseDao.deleteAll()

    suspend fun getAllData() = databaseDao.getAllData().flowOn(Dispatchers.IO)
        .conflate()

}
package com.first.dice.mydatabase.RoomDB

import androidx.lifecycle.LiveData
import org.w3c.dom.Entity

class myRepository(private val userDao : Dao) {

    val readAllData : LiveData<List<UserEntity>> = userDao.realAllData()

    suspend fun addUser(user : UserEntity){
        userDao.addUser(user)
    }

    suspend fun upDateUset(user : UserEntity){
        userDao.updateUser(user)
    }

    suspend fun delectAUser(user: UserEntity){
        userDao.delectUser(user)
    }
    suspend fun delectAllUser(){
        userDao.delectAll()
    }
}
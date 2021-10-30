package com.first.dice.mydatabase.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.first.dice.mydatabase.RoomDB.UserEntity
import com.first.dice.mydatabase.RoomDB.myDatabase
import com.first.dice.mydatabase.RoomDB.myRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class myViewModel constructor(application : Application) : AndroidViewModel(application){

    var readAllData : LiveData<List<UserEntity>>
    private val repository : myRepository

    init {
        val userDao  = myDatabase.getDatabase(application).userDao()
        repository = myRepository(userDao)
        readAllData = repository.readAllData
    }

    fun addUser (user : UserEntity){
        viewModelScope.launch (Dispatchers.IO){
            repository.addUser(user)
        }
    }

    fun updateUser(user: UserEntity){
        viewModelScope.launch (Dispatchers.IO){
            repository.upDateUset(user)
        }
    }

    fun delectAllUser(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.delectAllUser()
        }
    }

    fun delectUser(user: UserEntity){
        viewModelScope.launch (Dispatchers.IO){
            repository.delectAUser(user)
        }
    }

}
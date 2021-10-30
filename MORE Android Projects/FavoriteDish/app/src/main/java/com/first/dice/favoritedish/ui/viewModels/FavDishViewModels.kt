package com.first.dice.favoritedish.ui.viewModels

import android.app.Application
import androidx.lifecycle.*
import com.first.dice.favoritedish.model.DataBase.Database
import com.first.dice.favoritedish.model.DataBase.FavDishDao
import com.first.dice.favoritedish.model.DataBase.FavDishRepo
import com.first.dice.favoritedish.model.FavDishEntity
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

//class FavDishViewModels (private val repository : FavDishRepo) : ViewModel(){
//    fun insert(dish : FavDishEntity ) = viewModelScope.launch {
//        repository.insertFavDishData(dish)
//    }
//}
//
//class FavDishModelFactory(private val repository: FavDishRepo) : ViewModelProvider.Factory{
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        if(modelClass.isAssignableFrom(FavDishViewModels::class.java)){
//            @Suppress("UNCHECKED_CAST")
//            return FavDishViewModels(repository) as T
//
//        }else {
//            throw IllegalArgumentException("Unknow ViewModel Class")
//        }
//    }
//
//
//}

class FavDishViewModels(application : Application):AndroidViewModel(application){
    private val dao : LiveData<List<FavDishDao>>
    private val repositry : FavDishRepo

    init {
        val userDao =
    }

}
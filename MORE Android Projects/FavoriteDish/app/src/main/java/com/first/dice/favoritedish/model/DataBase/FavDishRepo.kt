package com.first.dice.favoritedish.model.DataBase

import androidx.annotation.WorkerThread
import com.first.dice.favoritedish.model.FavDishEntity

class FavDishRepo(private val favDishDao: FavDishDao) {
    @WorkerThread
    suspend fun insertFavDishData(favDishentitys : FavDishEntity){
        favDishDao.insertFavDishDetails(favDishentitys)
    }
}
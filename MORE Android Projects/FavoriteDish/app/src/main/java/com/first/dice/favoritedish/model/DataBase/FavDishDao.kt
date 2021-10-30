package com.first.dice.favoritedish.model.DataBase

import androidx.room.Dao
import androidx.room.Insert
import com.first.dice.favoritedish.model.FavDishEntity


@Dao
interface FavDishDao {

    @Insert
    suspend fun insertFavDishDetails(favDish : FavDishEntity)
}
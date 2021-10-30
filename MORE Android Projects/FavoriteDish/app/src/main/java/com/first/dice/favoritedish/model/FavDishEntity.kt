package com.first.dice.favoritedish.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fav_dish_table")

data class FavDishEntity(
    @ColumnInfo val image :String ,
    @ColumnInfo(name = "image_source") val imageSource: String ,
    @ColumnInfo val title : String,
    @ColumnInfo val type : String,
    @ColumnInfo val category : String,
    @ColumnInfo val ingrediance : String,

    @ColumnInfo(name = "cooking_time") val cookingTime : String,
    @ColumnInfo(name = "instruction") val directionToCook :String ,
    @ColumnInfo(name = "favorite_dish") val favoriteDish : Boolean = false,

    @PrimaryKey(autoGenerate = true)val id : Int = 0

)
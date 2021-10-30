package com.first.dice.mydatabase.RoomDB

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "my_table")
data class UserEntity (

    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val name : String,
    val lastName : String,
    val age : Int

        ) : Parcelable
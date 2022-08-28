package com.example.e_commerceapplication.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Product(
    var id: Int,
    var name: String,
    val gender: String,
    val category: String,
    val image: String,
    val price: Int,
    val description: String,
    val color: String
){

}
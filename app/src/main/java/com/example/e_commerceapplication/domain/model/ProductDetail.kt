package com.example.e_commerceapplication.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ProductDetail(
    var id: Int,
    var name: String,
    val image: String,
    val price: Int,
    val description: String

){

}

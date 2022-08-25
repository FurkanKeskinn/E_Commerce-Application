package com.example.e_commerceapplication.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class User(
    var username: String,
    var mail: String,
    val password: String,
    val phone: Int
) {

}

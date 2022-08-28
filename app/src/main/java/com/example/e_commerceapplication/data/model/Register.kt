package com.example.e_commerceapplication.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Register(
    var username: String,
    var mail: String,
    val password: String,
    val phone: Int
) {

}

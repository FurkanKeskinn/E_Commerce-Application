package com.example.e_commerceapplication.data.remote.dto

import com.example.e_commerceapplication.domain.model.User

data class UserDto(
    var username: String,
    var mail: String,
    val password: String,
    val phone: Int
)

fun UserDto.toUser(): User{
    return User(
        username = username,
        mail = mail,
        password = password,
        phone = phone
    )
}
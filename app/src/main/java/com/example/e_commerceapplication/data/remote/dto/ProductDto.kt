package com.example.e_commerceapplication.data.remote.dto

import com.example.e_commerceapplication.domain.model.Product

data class ProductDto(
    var id: Int,
    var name: String,
    val gender: String,
    val category: String,
    val image: String,
    val price: Int,
    val description: String,
    val color: String
)
fun ProductDto.toProduct(): Product{
    return Product(
        id = id,
        name = name,
        gender = gender,
        category = category,
        image = image,
        price = price,
        description = description,
        color = color
    )
}


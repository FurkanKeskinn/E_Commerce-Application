package com.example.e_commerceapplication.data.remote.dto

import com.example.e_commerceapplication.domain.model.ProductDetail

data class ProductDetailDto(
    var id: Int,
    var name: String,
    val image: String,
    val price: Int,
    val description: String
)

fun ProductDetailDto.toProductDetail(): ProductDetail{
    return ProductDetail(
        id = id,
        name = name,
        image = image,
        price = price,
        description = description
    )
}

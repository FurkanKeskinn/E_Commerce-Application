package com.example.e_commerceapplication.data


import com.example.e_commerceapplication.common.Resource
import com.example.e_commerceapplication.data.remote.dto.UserDto
import com.example.e_commerceapplication.domain.model.Product
import com.example.e_commerceapplication.domain.model.ProductDetail
import com.example.e_commerceapplication.domain.model.User
import retrofit2.Call
import retrofit2.http.*

interface CommerceApi {

    @POST("/register")
    @FormUrlEncoded
    fun register(
        @Field("username") username: String,
        @Field("mail") mail: String,
        @Field("password") password: String,
        @Field("phone") phone: Int
    ): Call<UserDto>

    @POST("/login")
    @FormUrlEncoded
    fun login(
        @Field("mail") mail: String,
        @Field("password") password: String
    ): Call<User>

    @POST("/urun/ekle")
    @FormUrlEncoded
    fun addProduct(
        @Field("name") name: String,
        @Field("gender") gender: String,
        @Field("category") category: String,
        @Field("image") image: String,
        @Field("price") price: Int,
        @Field("description") description: String,
        @Field("color") color: String,
    ): Call<Product>

    @POST("/urunler")
    @FormUrlEncoded
    fun getProduct(
        @Field("id") id: Int,
        @Field("name") name: String,
        @Field("image") image: String,
        @Field("price") price: Int
    ): Call<Product>

    @GET("/urun/{url}")
    fun getByIdProduct(@Path ("id") id: String): Call<ProductDetail>
}
package com.example.e_commerceapplication.data.service


import com.example.e_commerceapplication.common.Resource
import com.example.e_commerceapplication.data.model.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface CommerceApi {

    @POST("register")
    @FormUrlEncoded
    fun register(
        @Field("username") username: String,
        @Field("mail") mail: String,
        @Field("password") password: String,
        @Field("phone") phone: Int
    ): Call<Register>

    @POST("login")
    @FormUrlEncoded
    fun login(
        @Field("mail") mail: String,
        @Field("password") password: String
    ): Call<Login>

    @POST("urun/ekle")
    @FormUrlEncoded
    fun addProduct(
        @Field("name") name: String,
        @Field("gender") gender: String,
        @Field("category") category: String,
        @Field("image") image: String,
        @Field("price") price: Int,
        @Field("description") description: String,
        @Field("color") color: String,
    ): Call<List<Product>>

    @GET("urunler")
   fun getProduct(): Call<Product>

    @GET("urun/{id}")
    fun getByIdProduct(@Path ("id") id: Int): Call<Product>
}
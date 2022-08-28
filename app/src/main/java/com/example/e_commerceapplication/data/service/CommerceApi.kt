package com.example.e_commerceapplication.data.service


import com.example.e_commerceapplication.data.model.Login
import com.example.e_commerceapplication.data.model.Product
import com.example.e_commerceapplication.data.model.ProductDetail
import com.example.e_commerceapplication.data.model.Register
import retrofit2.Call
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
    ): Call<Product>

    @GET("urunler")
    fun getProduct(): Call<List<Product>>

    @GET("urun/{url}")
    fun getByIdProduct(@Path ("id") id: Int): Call<ProductDetail>
}
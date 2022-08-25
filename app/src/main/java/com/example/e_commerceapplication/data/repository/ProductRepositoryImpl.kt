package com.example.e_commerceapplication.data.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.e_commerceapplication.data.CommerceApi
import com.example.e_commerceapplication.data.remote.dto.UserDto
import com.example.e_commerceapplication.domain.model.Product
import com.example.e_commerceapplication.domain.model.User
import com.example.e_commerceapplication.domain.repository.ProductRepository
import retrofit2.Call
import javax.inject.Inject

class ProductRepositoryImpl(context: Context){

    var productList = MutableLiveData<List<Product>>()


}
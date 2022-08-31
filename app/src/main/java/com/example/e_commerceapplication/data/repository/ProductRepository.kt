package com.example.e_commerceapplication.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.e_commerceapplication.common.Resource
import com.example.e_commerceapplication.data.model.Product
import com.example.e_commerceapplication.data.model.ProductDetail
import com.example.e_commerceapplication.data.model.Register
import com.example.e_commerceapplication.data.service.CommerceApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ProductRepository @Inject constructor(private val api: CommerceApi) {

   suspend fun getProducts() = api.getProduct()

    /*var productLiveData = MutableLiveData<List<Product>>()
    var addProductLiveData = MutableLiveData<List<Product>>()
    var productDetailLiveData = MutableLiveData<ProductDetail>()
    var isLoading = MutableLiveData<Boolean>()*/

   /* fun getProduct() {
        val call: Call<List<Product>> = api.getProduct()
        call.enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                response.body()?.let {
                    productLiveData.value = it
                    isLoading.value = false
                } ?: run {
                    isLoading.value = false
                }
                if (response.isSuccessful){
                    productLiveData.postValue(response.body())
                }

            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                t.localizedMessage?.toString()?.let { Log.e("Product Failure", it) }
                isLoading.value = false

            }

        })

    }*/

    /*fun addProduct(
        name: String,
        gender: String,
        category: String,
        image: String,
        price: Int,
        description: String,
        color: String
    ) {
        val call: Call<List<Product>> = api.addProduct(
            name = name,
            gender = gender,
            category = category,
            image = image,
            price = price,
            description = description,
            color = color
        )
        call.enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {

                if (response.isSuccessful) {
                    addProductLiveData.postValue(response.body())
                    Log.e("response", "ürün kaydı başarılı")
                    isLoading.value = false

                } else {
                    Log.e("response", "ürün kaydı başarısız 1")
                    isLoading.value = false
                }
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                t.localizedMessage?.toString()?.let { Log.e("Product Failure", it) }
                isLoading.value = false
            }

        })
    }*/

   /* fun getByIdProduct(id: Int) {
        val call: Call<ProductDetail> = api.getByIdProduct(id = id)
        call.enqueue(object : Callback<ProductDetail> {

            override fun onResponse(call: Call<ProductDetail>, response: Response<ProductDetail>) {
                if (response.isSuccessful) {
                    productDetailLiveData.postValue(response.body())
                    Log.e("response", "ürün geldi")
                    isLoading.value = false

                } else {
                    Log.e("response", "ürün gelmedi 1")
                    isLoading.value = false
                }
            }

            override fun onFailure(call: Call<ProductDetail>, t: Throwable) {
                t.localizedMessage?.toString()?.let { Log.e("Product Failure gelmedi", it) }
                isLoading.value = false
            }


        })
    }*/

}
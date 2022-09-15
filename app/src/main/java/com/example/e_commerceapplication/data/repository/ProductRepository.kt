package com.example.e_commerceapplication.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.e_commerceapplication.data.model.Product
import com.example.e_commerceapplication.data.model.ResultItem
import com.example.e_commerceapplication.data.service.CommerceApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ProductRepository @Inject constructor(private val api: CommerceApi) {

    var productDetailLiveData : MutableLiveData<ResultItem?>? = null

    fun getProduct(liveData: MutableLiveData<List<ResultItem?>?>) {

        val call: Call<Product> = api.getProduct()
        call.enqueue(object: Callback<Product>{
            override fun onResponse(call: Call<Product>, response: Response<Product>) {
                if (response.isSuccessful){
                    liveData.postValue(response.body()?.result)
                }else{
                    liveData.postValue(null)
                }
            }
            override fun onFailure(call: Call<Product>, t: Throwable) {
                liveData.postValue(null)
            }
        })
    }

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

    fun getByIdProduct(id: Int) : MutableLiveData<ResultItem?>?{
        val call: Call<Product> = api.getByIdProduct(id)
        call.enqueue(object : Callback<Product> {

            override fun onResponse(call: Call<Product>, response: Response<Product>) {
                if (response.isSuccessful) {
                    productDetailLiveData?.postValue(response.body()?.result?.get(id))
                    Log.e("response", "ürün geldi")

                } else {
                    Log.e("response", "ürün gelmedi 1")
                    productDetailLiveData?.postValue(null)
                }
            }

            override fun onFailure(call: Call<Product>, t: Throwable) {
                t.localizedMessage?.toString()?.let { Log.e("Product Failure gelmedi", it) }
                productDetailLiveData?.postValue(null)

            }

        })
        return productDetailLiveData
    }


}
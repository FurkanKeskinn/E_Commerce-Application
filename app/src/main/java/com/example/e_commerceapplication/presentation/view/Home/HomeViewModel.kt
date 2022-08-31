package com.example.e_commerceapplication.presentation.view.Home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_commerceapplication.data.model.Product
import com.example.e_commerceapplication.data.model.Products
import com.example.e_commerceapplication.data.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: ProductRepository): ViewModel(){

    /*  private var productListLiveData = MutableLiveData<List<Product>>()
    val productList: LiveData<List<Product>>
        get() = productListLiveData

    fun getProducts() = viewModelScope.launch {
        repository.getProduct().let {
            if(it.){
                productListLiveData.value = it.
            }else{
                Log.e("Error : ", it.code().toString())
            }
        }
    }
   fun  observerShows(): LiveData<Product>{
        return productListLiveData
    }


   private var _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    init {
        //_isLoading = repository.isLoading
        loadData()
        productListLiveData = MutableLiveData()
    }

    fun getLiveDataObserver(): MutableLiveData<List<Product>>{
        return productListLiveData
    }

    fun loadData(){
        repository.getProduct()
        productListLiveData = repository.productLiveData
        //_isLoading = repository.isLoading


    }*/

    private val products = MutableLiveData<Products>()

    fun getProducts() = viewModelScope.launch {

        repository.getProducts().let {

            if (it.isSuccessful){
                products.value = it.body()
            }else{
                Log.e("Error: ", it.code().toString())
            }
        }
    }
    fun observeProducts(): LiveData<Products>{
        return products
    }
}
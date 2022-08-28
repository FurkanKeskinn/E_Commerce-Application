package com.example.e_commerceapplication.presentation.view.Home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.e_commerceapplication.data.model.Product
import com.example.e_commerceapplication.data.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor( private val repository: ProductRepository): ViewModel(){

     var productListLiveData: MutableLiveData<List<Product>>

    /*val productList: LiveData<List<Product>>
        get() = productListLiveData*/

    /*private var _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading*/

    init {
       // _isLoading = repository.isLoading
        //getProduct()
        productListLiveData = MutableLiveData()
    }
    fun getLiveDataObserver(): MutableLiveData<List<Product>>{
        return productListLiveData
    }

    fun loadData(){
        repository.getProduct(productListLiveData)
        //productListLiveData = repository.productLiveData
        //_isLoading = repository.isLoading

    }
}
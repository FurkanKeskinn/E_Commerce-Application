package com.example.e_commerceapplication.presentation.view.Home

import android.util.Log
import androidx.lifecycle.*
import com.example.e_commerceapplication.data.model.Product
import com.example.e_commerceapplication.data.model.ResultItem
import com.example.e_commerceapplication.data.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: ProductRepository): ViewModel(){

    var liveData: MutableLiveData<Product> = MutableLiveData()

    fun getLiveDataObserver(): MutableLiveData<Product>{
        return liveData
    }

    fun loadData(){
        repository.getProduct(liveData)
    }

}
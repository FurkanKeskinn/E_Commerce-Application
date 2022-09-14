package com.example.e_commerceapplication.presentation.view.home

import androidx.lifecycle.*
import com.example.e_commerceapplication.data.model.ResultItem
import com.example.e_commerceapplication.data.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: ProductRepository): ViewModel(){

    var liveData: MutableLiveData<List<ResultItem?>?> = MutableLiveData()

    init {
        loadData()
    }
    fun getLiveDataObserver(): MutableLiveData<List<ResultItem?>?>{
        return liveData
    }

    fun loadData(){
        repository.getProduct(liveData)
    }
}
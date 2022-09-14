package com.example.e_commerceapplication.presentation.view.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.e_commerceapplication.data.model.ResultItem
import com.example.e_commerceapplication.data.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor(private val repository: ProductRepository): ViewModel(){

    private var liveData: MutableLiveData<ResultItem> = MutableLiveData()
private val id :Int? = null

    init {

       id?.let {getData(id)}
    }
    fun getLiveDataObserver(): MutableLiveData<ResultItem>{
        return liveData
    }

    fun getData(id: Int?){
        if (id != null) {
            repository.getByIdProduct(id)
        }


    }
}
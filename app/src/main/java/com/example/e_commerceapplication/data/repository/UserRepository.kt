package com.example.e_commerceapplication.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.e_commerceapplication.common.Resource
import com.example.e_commerceapplication.data.model.Login
import com.example.e_commerceapplication.data.model.Product
import com.example.e_commerceapplication.data.model.ProductDetail
import com.example.e_commerceapplication.data.model.Register
import com.example.e_commerceapplication.data.service.CommerceApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val api: CommerceApi
) {
    var registerLiveData = MutableLiveData<Register>()
    var loginLiveData = MutableLiveData<Login>()
    var isLoading = MutableLiveData<Boolean>()

    fun register(username: String, mail: String, password: String, phone: Int) {

        val call: Call<Register> = api.register(username = username, mail = mail, password = password, phone = phone)
        call.enqueue(object: Callback<Register> {
            override fun onResponse(call: Call<Register>, response: Response<Register>) {

                if (response.isSuccessful){
                    registerLiveData.postValue(response.body())
                    Log.e("response", "kayıt başarılı")
                    isLoading.value = false
                }else{
                    Log.e("response", "kayıt başarısız 1")
                    isLoading.value = false
                }
            }

            override fun onFailure(call: Call<Register>, t: Throwable) {
                Log.e("response", "kayıt başarısız 2")
                isLoading.value = false
            }

        })
    }

    fun login(mail: String, password: String){
        val call: Call<Login> = api.login(mail = mail, password = password)
        call.enqueue(object : Callback<Login>{
            override fun onResponse(call: Call<Login>, response: Response<Login>) {
                if (response.isSuccessful){
                    loginLiveData.postValue(response.body())
                    Log.e("response", "giriş başarılı")
                    isLoading.value = false
                }else{
                    Log.e("response", "giriş başarısız 1")
                    isLoading.value = false
                }
            }
            override fun onFailure(call: Call<Login>, t: Throwable) {
                Log.e("response", "giriş Failure")
                isLoading.value = false
            }

        })
    }
}
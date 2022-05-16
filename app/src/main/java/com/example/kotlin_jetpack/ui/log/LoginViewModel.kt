package com.example.kotlin_jetpack.ui.log

import android.text.Editable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin_jetpack.Api.OnSellRepository

import com.example.kotlin_jetpack.bean.Login_bena
import com.example.kotlin_jetpack.bean.YzCode_Bean


import kotlinx.coroutines.launch

class LoginViewModel :ViewModel() {
    val getcode= MutableLiveData<YzCode_Bean>()
    val login= MutableLiveData<Login_bena>()
    private val onSellRepository by lazy{
        OnSellRepository()
    }
    fun code(id: Long){
        viewModelScope.launch {
            val bean=onSellRepository.getCode(id)
            getcode.value=bean
        }
    }

    fun getlog(id:Long,yzm:Int){
        viewModelScope.launch {
            val  bean=onSellRepository.Login(id,yzm)
            login.value=bean
        }
    }
}
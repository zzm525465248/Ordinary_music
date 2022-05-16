package com.example.kotlin_jetpack.ui.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin_jetpack.Api.OnSellRepository
import com.example.kotlin_jetpack.bean.Login_bena
import com.example.kotlin_jetpack.bean.User_Bean
import com.example.kotlin_jetpack.bean.User_PlayList_Bean
import kotlinx.coroutines.launch

class DashboardViewModel : ViewModel() {
    val userlist= MutableLiveData<User_Bean>()

    val playlist= MutableLiveData<User_PlayList_Bean>()
    private val onSellRepository by lazy{
        OnSellRepository()
    }
    fun getuser(cookie:String,id:Int){
        viewModelScope.launch {
            val  bean=onSellRepository.User(cookie,id)
            userlist.value=bean
        }
    }
    fun getplaylist(id: Int){
        viewModelScope.launch {
            val bean=onSellRepository.get_user_playlist(id)
            playlist.value=bean
        }
    }

}
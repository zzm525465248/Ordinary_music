package com.example.kotlin_jetpack.ui.ui.dashboard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin_jetpack.Api.OnSellRepository
import com.example.kotlin_jetpack.bean.Data1
import com.example.kotlin_jetpack.bean.Song_details_Bean
import com.example.kotlin_jetpack.bean.User_PlayList_Bean
import kotlinx.coroutines.launch

class loveViewModel :ViewModel() {
    val songlist= MutableLiveData<List<Int>>()
    val lovelist= MutableLiveData<List<Song_details_Bean.Song>>()
    val song_url= MutableLiveData<List<Data1>>()

    private val onSellRepository by lazy{
        OnSellRepository()
    }
    fun getlist(id:Int,tk:String){
        viewModelScope.launch {
            val bean=onSellRepository.Lovelist(id,tk)
            songlist.value=bean.ids
        }
    }
    //获取歌曲详情
    fun getlove_details(list: String){
        viewModelScope.launch {
            val bean=onSellRepository.getlove_Details(list)
            lovelist.value=bean.songs
        }
    }

    fun getUrl(id:String){
        viewModelScope.launch {
            val bean=onSellRepository.songURL_List(id)
            song_url.value=bean.data
        }
    }


}
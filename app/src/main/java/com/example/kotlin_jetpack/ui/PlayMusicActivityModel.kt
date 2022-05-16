package com.example.kotlin_jetpack.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin_jetpack.Api.OnSellRepository
import com.example.kotlin_jetpack.bean.Klyric
import com.example.kotlin_jetpack.bean.Lrc
import kotlinx.coroutines.launch

class PlayMusicActivityModel:ViewModel() {
    val songlyric_list= MutableLiveData<Lrc>()

    val songlist= MutableLiveData<List<Int>>()

    val lyric: LiveData<Lrc>
        get() = songlyric_list

    private val onSellRepository by lazy{
        OnSellRepository()
    }

    fun getsonglyric_list(id:Int){
        viewModelScope.launch {
            val bean=onSellRepository.songLyric(id)
            songlyric_list.value=bean.lrc
        }
    }
    fun getlist(id:Int,tk:String){
        viewModelScope.launch {
            val bean=onSellRepository.Lovelist(id,tk)
            songlist.value=bean.ids
        }
    }
}
package com.example.kotlin_jetpack.ui.song_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.kotlin_jetpack.Api.OnSellRepository
import com.example.kotlin_jetpack.JetPack.Paging.Pagin_songsheet_list
import com.example.kotlin_jetpack.JetPack.Paging.Paging
import com.example.kotlin_jetpack.bean.PageConfig
import com.example.kotlin_jetpack.bean.RecommendedSongListBean
import com.example.kotlin_jetpack.bean.Recommended_song_list_Bean
import kotlinx.coroutines.launch

class GedansquareViewModel : ViewModel() {
    val songsheet_classification= MutableLiveData<Songsheet_classification_Bean.data>()
    val recommended_song_list= MutableLiveData<List<Recommended_song_list_Bean.Recommend>>()

    private val onSellRepository by lazy{
        OnSellRepository()
    }

    //获取歌单分类
    fun get_songsheet_fl(){
        viewModelScope.launch {
            val bean=onSellRepository.get_songsheet_fl()
            songsheet_classification.value=bean
        }
    }

    //获取推荐歌单
    fun get_Recommended_song_list(){
        viewModelScope.launch {
            val bean=onSellRepository.get_recommended_song_list()
            recommended_song_list.value=bean.recommend
        }
    }

    //paging
    fun get_songsheet_paging(name:String)= Pager(PagingConfig(pageSize = 30)){
        Pagin_songsheet_list(name)
    }.flow
}
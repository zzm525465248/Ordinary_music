package com.example.kotlin_jetpack.ui.ui.home

import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin_jetpack.Api.OnSellRepository
import com.example.kotlin_jetpack.R
import com.example.kotlin_jetpack.bean.*


import kotlinx.coroutines.launch


class HomeViewModel : ViewModel() {
    val banner_list= MutableLiveData<List<BannerX>>()
    val recommendedsonglist=MutableLiveData<List<Results>>()
    val homelist= MutableLiveData<List<Block>>()
    val songlist=MutableLiveData<List<Data1>>()
    val qbfwlist= MutableLiveData<List<Datas>>()
    val songdetails_list=MutableLiveData<List<Song_details_Bean.Song>>()
    private val onSellRepository by lazy{
        OnSellRepository()
    }

    //首页全部服务
    fun Qbfw_home(){
        viewModelScope.launch {
            val bean=onSellRepository.homeQbfw()
            qbfwlist.value=bean.data
        }
    }


    //首页轮播图
    fun Banner_home(){
        this.banner()
    }

    //歌单推荐
    fun RecommendedSongList(){
        this.getRecommendedSongListl()
    }

    //首页数据
    fun Home_List(){
        this.homeList()
    }

    //歌曲Url
    fun Song_List(id: Int){
        this.songList(id)
    }

    //获取歌曲数组URL
//    fun SongURl_List(id:List<Int>){
//        viewModelScope.launch {
//            val bean=onSellRepository.songURL_List(id)
//            songlist.value=bean.data
//        }
//    }

    //推荐歌单观察
    private fun getRecommendedSongListl(){
        viewModelScope.launch {
            val bean=onSellRepository.recommendedSongList()
            recommendedsonglist.value=bean.result
        }
    }

    //轮播图数据观察
    private fun banner(){
        viewModelScope.launch {
            val bean=onSellRepository.banner_list()
            banner_list.value=bean.banners


        }
    }

    //首页数据观察
    private fun homeList(){
        viewModelScope.launch {
            val bean=onSellRepository.homeList()
            homelist.value=bean.data.blocks
        }
    }

    //歌曲url数据观察
    private fun songList(id:Int){
        viewModelScope.launch {
            val  bean=onSellRepository.songUrl(id)
            songlist.value=bean.data
        }
    }

    //获取歌曲详情
    fun getUrl_list(list: String){
        viewModelScope.launch {
            val bean=onSellRepository.getlove_Details(list)
            songdetails_list.value=bean.songs
        }
    }



}



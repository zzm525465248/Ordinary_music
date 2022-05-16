package com.example.kotlin_jetpack.ui.song_list

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.example.kotlin_jetpack.Api.OnSellRepository
import com.example.kotlin_jetpack.JetPack.Paging.Pagin_songsheet_list
import com.example.kotlin_jetpack.JetPack.Paging.Paging
import com.example.kotlin_jetpack.bean.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class SonglistViewModer : ViewModel() {
    val songsheet_details=MutableLiveData<Playlist>()
    val songsheet_list= MutableLiveData<List<SongSheet_List_Bean.Song>>()
    val songlist=MutableLiveData<List<Data1>>()
    var id:MutableLiveData<Long> = MutableLiveData()
    var size:MutableLiveData<Int> = MutableLiveData()
    init {
        id.value=0
        size.value=60
        Log.d("name",id.toString())
    }

    private val onSellRepository by lazy{
        OnSellRepository()
    }

    fun getdetails(id:Long){
        viewModelScope.launch {
            val  bean=onSellRepository.songSheet_details(id)
            songsheet_details.value=bean.playlist


        }
    }

    fun get_list(id:Long,page:Int){
        viewModelScope.launch {
            val bean=onSellRepository.songSheet_list(id,page)
            songsheet_list.value=bean.songs
        }
    }
    //歌曲Url
    fun Song_List(id: Int){
        this.songList(id)
    }

    //歌曲url数据观察
    private fun songList(id:Int){
        viewModelScope.launch {
            val  bean=onSellRepository.songUrl(id)
            songlist.value=bean.data
        }
    }

    //获取歌曲数组URL
    fun SongURl_List(id:String){
        viewModelScope.launch {
            val bean=onSellRepository.songURL_List(id)
            songlist.value=bean.data
        }
    }

//    fun listdata(id: Long,size:Int)= Pager(PagingConfig(pageSize = 20)){
//        Paging(id,size)
//    }.flow

    private val songs by lazy {
        Pager(
            config = PagingConfig(pageSize = 30,prefetchDistance = 6,initialLoadSize = 60),
            pagingSourceFactory = { Paging(id.value!!.toLong(),size.value!!.toInt()) }
        ).flow.cachedIn(viewModelScope)
    }
    fun loadMovie(): Flow<PagingData<SongSheet_List_Bean.Song>> = songs
}
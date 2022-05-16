package com.example.kotlin_jetpack.ui.song_list

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.kotlin_jetpack.Api.OnSellRepository
import com.example.kotlin_jetpack.JetPack.Paging.Pagin_songsheet_list

import com.example.kotlin_jetpack.bean.SongSheetList_Bean
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class Gedansquare2ViewModel :ViewModel() {
    var tab_name:MutableLiveData<String> = MutableLiveData()
    val songsheet_list= MutableLiveData<SongSheetList_Bean>()
    private val onSellRepository by lazy{
        OnSellRepository()
    }
    init {
        tab_name.value="华语"
        Log.d("name",tab_name.toString())
    }



    fun get_songsheet_paging(name:String)= Pager(PagingConfig(pageSize = 50)){
        Pagin_songsheet_list(name)
    }.flow

    private val songs by lazy {
        Pager(
            config = PagingConfig(pageSize = 30,prefetchDistance = 6,initialLoadSize = 60),
            pagingSourceFactory = {Pagin_songsheet_list(tab_name.value.toString())}
        ).flow.cachedIn(viewModelScope)
    }
    fun loadMovie(): Flow<PagingData<SongSheetList_Bean.Playlists>> = songs

//    fun get(name: String){
//
//        viewModelScope.launch {
//            val bean=onSellRepository.get_songsheetlist(name, page.value!!.toInt(),0)
//            songsheet_list.value=bean
//            Log.d("page",page.value.toString())
//        }
//    }
}
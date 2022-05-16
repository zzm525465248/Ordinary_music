package com.example.kotlin_jetpack.ui.ui.review

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.kotlin_jetpack.JetPack.Paging.Pagin_songreview
import com.example.kotlin_jetpack.JetPack.Paging.Pagin_songsheet_list
import com.example.kotlin_jetpack.bean.Review_song_Bean
import com.example.kotlin_jetpack.bean.SongSheetList_Bean
import kotlinx.coroutines.flow.Flow

class songreview_viewmodel: ViewModel() {
    var tab_name: MutableLiveData<Int> = MutableLiveData()

    init {
        tab_name.value=0
        Log.d("name",tab_name.toString())
    }

    private val songs by lazy {
        Pager(
            config = PagingConfig(pageSize = 30,prefetchDistance = 6,initialLoadSize = 60),
            pagingSourceFactory = { Pagin_songreview(tab_name.value!!.toInt()) }
        ).flow.cachedIn(viewModelScope)
    }
    fun loadMovie(): Flow<PagingData<Review_song_Bean.Comment>> = songs
}
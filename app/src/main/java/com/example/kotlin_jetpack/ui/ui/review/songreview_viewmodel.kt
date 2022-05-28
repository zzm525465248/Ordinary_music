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
import com.example.kotlin_jetpack.bean.Review2_song_Bean
import kotlinx.coroutines.flow.Flow

class songreview_viewmodel: ViewModel() {
    var tab_name: MutableLiveData<Int> = MutableLiveData()
    var tab_type: MutableLiveData<Int> = MutableLiveData()


    init {
        tab_name.value=0
        tab_type.value=1
        Log.d("name",tab_name.toString())
        Log.d("name",tab_type.value.toString())
    }

    private val songs by lazy {
        Pager(
            config = PagingConfig(pageSize = 30,prefetchDistance = 6,initialLoadSize = 60),
            pagingSourceFactory = { Pagin_songreview(tab_name.value!!.toInt(),tab_type.value!!.toInt()) }
        ).flow.cachedIn(viewModelScope)
    }
    fun loadMovie(): Flow<PagingData<Review2_song_Bean.Data.Comment>> = songs
}
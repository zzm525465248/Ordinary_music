package com.example.kotlin_jetpack.JetPack.Paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.kotlin_jetpack.Api.ApiService
import com.example.kotlin_jetpack.Api.RetrofitClient


import com.example.kotlin_jetpack.bean.SongSheetList_Bean
import com.example.kotlin_jetpack.bean.SongSheet_List_Bean
import retrofit2.await
import java.lang.Exception

class Paging( val id:Long,val size:Int) : PagingSource<Int, SongSheet_List_Bean.Song>() {



    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, SongSheet_List_Bean.Song> {
        return    try {

            val page=params.key ?:0
            val pagesize=params.loadSize


            val response = RetrofitClient.create(ApiService::class.java).getSongSheet_list(id,page,pagesize).await()
          //  val response1 = RetrofitClient.create(ApiService::class.java).getSongSheet_list(id1,page+20,pagesize).await()
            Log.d("size",response.songs.size.toString())
            Log.d("size22",size.toString())
            var prevKey: Int? = null
            var nextKey: Int? = null
            val realPageSize = 30
            val initialLoadSize = 60
            if (page == 0) {
                prevKey = null
                nextKey = initialLoadSize / realPageSize + 30
            } else {
                prevKey = page - 30
                nextKey = page+30
            }


            Log.e("key2",response.songs[0].name)
            Log.d("hqk", "prevKey:$prevKey,nextKey:$nextKey")
            return LoadResult.Page(
                data = response.songs,
                prevKey = prevKey,
                nextKey = nextKey


            )
        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(e)
        }
    }



    override fun getRefreshKey(state: PagingState<Int, SongSheet_List_Bean.Song>): Int? =null

}



package com.example.kotlin_jetpack.JetPack.Paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.kotlin_jetpack.Api.ApiService
import com.example.kotlin_jetpack.Api.RetrofitClient
import com.example.kotlin_jetpack.bean.SongSheetList_Bean
import retrofit2.await
import java.lang.Exception

class Pagin_songsheet_list(val name: String) : PagingSource<Int, SongSheetList_Bean.Playlists>() {
    override fun getRefreshKey(state: PagingState<Int, SongSheetList_Bean.Playlists>): Int? = null

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, SongSheetList_Bean.Playlists> {

        return try {

            val page=params.key?:0
            val pagesize=params.loadSize
            val response = RetrofitClient.create(ApiService::class.java).get_songsheet_list(name,pagesize,page).await()
            Log.e("key2",response.playlists.size.toString())
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
            Log.d("hqk", "prevKey:$prevKey,nextKey:$nextKey")



           return LoadResult.Page(
                data = response.playlists,
                prevKey = prevKey,
                nextKey = nextKey
            )
        } catch (e: Exception){
            e.printStackTrace()
            LoadResult.Error(e)
        }
    }
}
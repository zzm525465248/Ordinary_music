package com.example.kotlin_jetpack.JetPack.Paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.kotlin_jetpack.Api.ApiService
import com.example.kotlin_jetpack.Api.RetrofitClient
import com.example.kotlin_jetpack.bean.Review_song_Bean
import retrofit2.await

class Pagin_songreview(val id:Int) :PagingSource<Int, Review_song_Bean.Comment>() {
    override fun getRefreshKey(state: PagingState<Int, Review_song_Bean.Comment>): Int? =null

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Review_song_Bean.Comment> {
        return  try {
            val page=params.key?:0
            val pagesize=params.loadSize
            val response=RetrofitClient.create(ApiService::class.java).get_song_review(id,pagesize,page).await()
            Log.d("gc",response.comments[0].content)
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

            return LoadResult.Page(
                data = response.comments,
                prevKey = prevKey,
                nextKey = nextKey
            )

        }catch (e :Exception){
            e.printStackTrace()
            LoadResult.Error(e)
        }

    }

}
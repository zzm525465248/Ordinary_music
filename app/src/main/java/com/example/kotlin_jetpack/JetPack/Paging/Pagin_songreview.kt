package com.example.kotlin_jetpack.JetPack.Paging

import android.util.Log
import android.widget.Toast
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.kotlin_jetpack.Api.ApiService
import com.example.kotlin_jetpack.Api.RetrofitClient
import com.example.kotlin_jetpack.bean.Review2_song_Bean
import retrofit2.await

class Pagin_songreview(val id: Int, var type:Int) :PagingSource<Int, Review2_song_Bean.Data.Comment>() {
    override fun getRefreshKey(state: PagingState<Int, Review2_song_Bean.Data.Comment>): Int? =null

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Review2_song_Bean.Data.Comment> {
        return  try {
            val page=params.key?:1
            val pagesize=params.loadSize
            Log.d("more",type.toString() )
            var prevKey: Int? = null
            var nextKey: Int? = null
            val response=RetrofitClient.create(ApiService::class.java).get_song_review2(id,0,page,pagesize,type,null).await()
            val itme=response.data.comments
            Log.d("gc",itme.size.toString())
            val realPageSize = 30
            val initialLoadSize = 60

            if (page == 1) {
                prevKey = null
                nextKey = initialLoadSize / realPageSize + 30
            } else if(response.data.hasMore) {
                prevKey = page - 30
                nextKey = page+30
            }else{
                Log.d("more","没有下一页拉" )

            }
            Log.d("hqk", "prevKey:$prevKey,nextKey:$nextKey")
            Log.d("hqk", page.toString())
            return LoadResult.Page(
                data = itme,
                prevKey = prevKey,
                nextKey = nextKey

            )

        }catch (e :Exception){
            e.printStackTrace()
            LoadResult.Error(e)
        }

    }

}
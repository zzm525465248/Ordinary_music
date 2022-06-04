package com.example.kotlin_jetpack.Api

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.lzx.starrysky.utils.KtPreferences
import com.lzx.starrysky.utils.KtPreferences.Companion.context
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.RuntimeException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class OnSellRepository {
    val sp= context?.getSharedPreferences("token", Context.MODE_PRIVATE)?.getString("cookie","www")

    private val apiService=RetrofitClient.create(ApiService::class.java)
    suspend fun searchPlaces(name: String)=apiService.getAppUser_Data4(name).await()
    suspend fun banner_list()=apiService.getBanner_list().await()
    suspend fun recommendedSongList()=apiService.getRecommendedSongList().await()
    suspend fun homeList()=apiService.getHomeList().await()
    suspend fun songUrl(id:Int)=apiService.getSongUrl(id).await()
    suspend fun songLyric(id:Int)=apiService.getSongLyric(id).await()


    suspend fun homeQbfw()=apiService.getHomeQbfw().await()

    suspend fun songSheet_details(id: Long,tk:String)=apiService.getSongsheet_details(id,tk).await()

    suspend fun songSheet_list(id: Long,page:Int)=apiService.getSongSheet_list(id,page,20,sp!!).await()

    suspend fun songURL_List(id:String)=apiService.getSongList_Url(id).await()

    suspend fun getCode(phone:Long)=apiService.getCode(phone).await()

    suspend fun Login(phone: Long,captcha:Int)=apiService.login(phone, captcha).await()

    suspend fun User(id:Int)=apiService.get_User(id).await()

    suspend fun Lovelist(id:Int,cookie:String)=apiService.get_Love_List(id,cookie).await()

    suspend fun getlove_Details( list: String)=apiService.get_song_details(list).await()

    suspend fun get_user_playlist(id: Int)=apiService.get_user_playlist(id).await()

    //获取歌单分类
    suspend fun get_songsheet_fl()=apiService.get_songsheet_classification().await()

    //获取推荐歌单
    suspend fun get_recommended_song_list()=apiService.get_Recommended_song_list(sp!!).await()


    //获取歌单
    suspend fun get_songsheetlist(name: String, size: Int, page:Int)=apiService.get_songsheet_list(name,size,page).await()


    private suspend fun <T> Call<T>.await():T{
        return suspendCoroutine { continuation ->
            enqueue(object :Callback<T>{
                override fun onResponse(call: Call<T>, response: Response<T>) {
                   val body=response.body()

                    if(body!=null){ continuation.resume(body)
                    }else continuation.resumeWithException(
                        RuntimeException(response.message() )
                    )
                }

                override fun onFailure(call: Call<T>, t: Throwable) {
                   continuation.resumeWithException(t)
                    Log.d("Throwable",call.toString())
                }

            })
        }
    }

}
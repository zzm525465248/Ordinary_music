package com.example.kotlin_jetpack.Api

import android.content.Context
import android.content.SharedPreferences
import android.view.View
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {




    val okHttpClient=OkHttpClient.Builder()
        .callTimeout(30,TimeUnit.SECONDS)
        .build()

    val retrofit =Retrofit.Builder()
        .baseUrl(ApiService.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

//    val apiService =retrofit.create(ApiService::class.java)

    fun <T> create(serviceCalss:  Class<T>):T =retrofit.create(serviceCalss)
    inline fun <reified T> create():T= create(T::class.java)
}
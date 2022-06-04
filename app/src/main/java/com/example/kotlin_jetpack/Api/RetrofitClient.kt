package com.example.kotlin_jetpack.Api

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import android.view.View
import com.lzx.starrysky.utils.KtPreferences.Companion.context
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {




    val okHttpClient=OkHttpClient.Builder()
        .callTimeout(30,TimeUnit.SECONDS)
        .addInterceptor(AddCookiesInterceptor())
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

//拦截Cookie保存到本地的拦截器
class ReceivedCookiesInterceptor :Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        TODO("Not yet implemented")
    }

}

//添加本地Cookie进行网络访问的拦截器
class AddCookiesInterceptor :Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder :Request.Builder=chain.request().newBuilder()
        val sp= context?.getSharedPreferences("token",Context.MODE_PRIVATE)?.getString("cookie","www")

        Log.d("sp",sp.toString())
        builder.addHeader("cookie",sp.toString())

        return chain.proceed(builder.build());
    }


}
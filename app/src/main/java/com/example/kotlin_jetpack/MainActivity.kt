package com.example .kotlin_jetpack

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log

import android.view.View
import android.view.WindowManager
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_jetpack.Api.AddCookiesInterceptor
import com.example.kotlin_jetpack.Api.ApiService
import com.example.kotlin_jetpack.JetPack.MainViewModel
import com.example.kotlin_jetpack.R
import com.example.kotlin_jetpack.bean.Login_statue_Bean
import com.example.kotlin_jetpack.ui.MainActivity_home
import com.example.kotlin_jetpack.ui.Unit.visibleAlphaAnimation
import com.example.kotlin_jetpack.ui.log.Login
import com.gyf.barlibrary.ImmersionBar
import com.lzx.starrysky.SongInfo
import com.lzx.starrysky.StarrySky
import com.lzx.starrysky.utils.KtPreferences.Companion.context
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.concurrent.fixedRateTimer


class MainActivity : AppCompatActivity()   {
    lateinit var bt:Button
    lateinit var bt2:Button
    lateinit var timer: Timer
    private val model: MainViewModel by viewModels()
    override fun onDestroy() {
        super.onDestroy()
        timer.cancel()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ImmersionBar.with(this).statusBarDarkFont(true).init()
        bt=findViewById(R.id.button4)
        bt2=findViewById(R.id.button5)

        bt.setOnClickListener {
            val intent=Intent(this,Login::class.java)
            startActivity(intent)
        }


        val okHttpClient= OkHttpClient.Builder()
            .callTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(AddCookiesInterceptor())
            .build()



        val tk= context?.getSharedPreferences("token",Context.MODE_PRIVATE)?.getString("cookie","www")
        if(tk.equals("www")){
            bt.visibleAlphaAnimation()
            bt2.visibleAlphaAnimation()
        }else{

            val retrofit = Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://47.101.205.65:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val apiService =retrofit.create(ApiService::class.java)
            apiService.login_status(tk.toString()).enqueue(object : Callback<Login_statue_Bean> {
                override fun onResponse(
                    call: Call<Login_statue_Bean>,
                    response: Response<Login_statue_Bean>
                ) {
                    val bean=response.body()
                    Log.d("log",bean.toString())

                    if (bean != null) {
                        if(bean.data.code==200){
                            Log.d("log",bean.data.account.id.toString())
                            getSharedPreferences("token",Context.MODE_PRIVATE).edit{
                                putInt("id",bean.data.account.id)
                                putString("name",bean.data.profile.nickname)
                                putString("imag",bean.data.profile.avatarUrl)
                                putString("backgroundUrl",bean.data.profile.backgroundUrl)
                                putString("jj",bean.data.profile.signature)
                                putString("tx",bean.data.profile.avatarUrl)


                            }

                            timer=    fixedRateTimer("", false, 1000, 6000) {
                                val intent=Intent(this@MainActivity,MainActivity_home::class.java)
                                startActivity(intent)
                                finish()
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<Login_statue_Bean>, t: Throwable) {
                    Log.d("e",t.toString())
                    Log.d("e",call.toString())
                }

            })
        }
        Log.d("log",tk.toString())

        }




    }










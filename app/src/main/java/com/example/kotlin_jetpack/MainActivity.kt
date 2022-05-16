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
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
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













//
//        bt.setOnClickListener {
//         model.song_User()
        val tk= context?.getSharedPreferences("token",Context.MODE_PRIVATE)?.getString("cookie","www")
        Log.d("log",tk.toString())
            val retrofit = Retrofit.Builder()
                .baseUrl("https://netease-cloud-music-api-dsjje2q7f-zzm525465248.vercel.app/")
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
                    Log.d("log",tk.toString())
                    if (bean != null) {
                        if(bean.data.code==200){
                            Log.d("log",bean.data.account.id.toString())
                            getSharedPreferences("token",Context.MODE_PRIVATE).edit{
                                putInt("id",bean.data.account.id)
                                putString("name",bean.data.profile.nickname)
                                putString("imag",bean.data.profile.avatarUrl)


                            }

                            timer=    fixedRateTimer("", false, 1000, 6000) {
                                val intent=Intent(this@MainActivity,MainActivity_home::class.java)
                                startActivity(intent)
                                finish()
                            }
                        }else{

                            bt.visibleAlphaAnimation()
                            bt2.visibleAlphaAnimation()
                        }
                    }
                }

                override fun onFailure(call: Call<Login_statue_Bean>, t: Throwable) {
                        Log.d("e",t.toString())
                }

            })
        }
        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.



    }










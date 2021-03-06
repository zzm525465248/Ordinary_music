package com.example.kotlin_jetpack.ui.ui

import android.animation.ObjectAnimator
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import android.widget.SeekBar
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.dirror.lyricviewx.LyricViewX
import com.dirror.lyricviewx.LyricViewXInterface
import com.dirror.lyricviewx.OnPlayClickListener
import com.dirror.lyricviewx.OnSingleClickListener
import com.example.kotlin_jetpack.Api.ApiService
import com.example.kotlin_jetpack.Api.OnSellRepository
import com.example.kotlin_jetpack.Api.RetrofitClient
import com.example.kotlin_jetpack.Api.toMinAndSeconds
import com.example.kotlin_jetpack.R
import com.example.kotlin_jetpack.bean.SongLyric_Bean
import com.example.kotlin_jetpack.databinding.ActivityPlayMusicBinding
import com.example.kotlin_jetpack.ui.PlayMusicActivityModel

import com.example.kotlin_jetpack.ui.Unit.BaseActivity
import com.example.kotlin_jetpack.ui.ui.review.Songreview


import com.lzx.starrysky.OnPlayProgressListener
import com.lzx.starrysky.SongInfo
import com.lzx.starrysky.StarrySky

import jp.wasabeef.glide.transformations.BlurTransformation
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Play_Music : BaseActivity() {
    private val playerController = StarrySky.with()
    var mediaPlayerList: MutableList<SongInfo> = playerController.getPlayList()
    private lateinit var _binding: ActivityPlayMusicBinding
    val binding: ActivityPlayMusicBinding
        get() = _binding

    private val onSellRepository by lazy{
        OnSellRepository()
    }

    private val play_viewhodel by lazy {
        ViewModelProvider(this).get(PlayMusicActivityModel::class.java)
    }

    override fun initBinding() {
        super.initBinding()
        _binding = ActivityPlayMusicBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }



    override fun initView() {
        super.initView()
        val item = playerController.getNowPlayingSongInfo()
        getsong(item?.songId!!.toInt())
        love_song(item?.songId!!.toInt())

        // ???????????????????????????
        // ???????????????????????????
        binding.lyric.apply {
            setLabel("????????????")
            //???????????????????????????????????? [normalColor]
            setNormalColor(R.color.xui_btn_green_normal_color)
            //???????????????????????????????????????
//            setTimelineColor(R.color.xui_config_color_white)
            //?????????????????????????????????????????????
//            setTimeTextColor(R.color.xui_config_color_white)
            //????????????????????????????????????????????????
//            setTimelineTextColor(R.color.xui_config_color_white)
        }
    }


    //????????????????????????
    private fun love_song(urlid: Int) {
        val sp = getSharedPreferences("token", Context.MODE_PRIVATE)
        val tk=sp?.getString("cookie","www")
        val id=sp?.getInt("id",132819237)
        if (id != null) {
            play_viewhodel.apply {
                songlist.observe(this@Play_Music, Observer {
                    for (app in it){
                        //??????????????????
                       if (urlid==app) {
                           Log.d("true","true")
                           binding.love.setImageResource(R.drawable.love2)
                           break
                       }else{
                           binding.love.setImageResource(R.drawable.love)
                       }

                    }
                })
            }.getlist(id.toInt(),tk.toString())
        }
    }

    override fun initListener() {
        super.initListener()
        binding.apply {
            //????????????
            discContainer.setOnClickListener {
                if (it.isVisible){
                    discContainer.visibility=View.INVISIBLE
                    lyricBj.visibility=View.VISIBLE


                }else{
                    discContainer.visibility=View.VISIBLE
                    lyricBj.visibility=View.INVISIBLE
                }


            }
            lyricBj.setOnClickListener {
                discContainer.visibility=View.VISIBLE
                lyricBj.visibility=View.INVISIBLE
            }




            //?????????
            iamgLast.setOnClickListener {
                if(playerController.isPlaying()){

                    playerController.skipToPrevious()
                    //???????????????
                    val item = playerController.getNowPlayingSongInfo()
                    getsong(item?.songId!!.toInt())
                }else if (!playerController.isPlaying()){

                    playerController.skipToPrevious()
                    val item = playerController.getNowPlayingSongInfo()
                    getsong(item?.songId!!.toInt())
                }
            }

            imagKs.setOnClickListener {
                if (playerController.isPlaying()){
                    playerController.pauseMusic()
                }else{
                    playerController.restoreMusic()
                }
            }
            //?????????
            imagNext.setOnClickListener {
                if(playerController.isPlaying()){

                    playerController.skipToNext()
                    //??????
                    val item = playerController.getNowPlayingSongInfo()
                    getsong(item?.songId!!.toInt())
                }else if (!playerController.isPlaying()){

                    playerController.skipToNext()
                    val item = playerController.getNowPlayingSongInfo()
                    getsong(item?.songId!!.toInt())
                }
            }

            //??????
            imageView8.setOnClickListener {
                finish()
                this@Play_Music.overridePendingTransition(
                    0,
                    R.anim.exit_animi
                )
            }

            //????????????
            imagComments.setOnClickListener {
                val intent=Intent(this@Play_Music,Songreview::class.java)
                startActivity(intent)
            }

        }
    }

    //??????????????????
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
        this@Play_Music.overridePendingTransition(
            0,
            R.anim.exit_animi
        )
    }

    override fun initObserver() {
        super.initObserver()
        val playDisc: ImageView = binding.play

        //????????????????????????
        playerController.playbackState().observe(this) {
            if (it.stage == "PLAYING" || it.stage == "PAUSE") {
                //????????????????????????
                val item = playerController.getNowPlayingSongInfo()

                item?.let {
                    playerController.getNowPlayingSongInfo()?.songId?.let { getsong(it.toInt()) }
                    love_song(item.songId.toInt())
                    Log.d("get", item.artist)
                    //????????????
                    val optionsBlur = RequestOptions().transform(BlurTransformation(15, 20))
                    Glide.with(this).load(item.songCover).apply(optionsBlur).into(binding.ImagBj)


                    Glide.with(this).load(item.songCover).into(binding.playWrite)
                    Glide.with(this).load(R.drawable.play_disc).apply(
                        RequestOptions.bitmapTransform(
                            CircleCrop()
                        )
                    ).into(playDisc)

                    binding.apply {
                        name.text = item.songName
                        songname.text = item.artist
                    }

//                    playerController.setOnPlayProgressListener(object : OnPlayProgressListener {
//                        override fun onPlayProgress(currPos: Long, duration: Long) {
//                            Log.d("currPos", (currPos / 100).toString())
//                            binding.lyric.updateTime(currPos)
//                        }
//
//                    })

                }

            }
            if(it.stage == "PLAYING"){
                binding.imagKs.setImageResource(R.drawable.zt)
                objectAnimator.resume()
            }else {
                binding.imagKs.setImageResource(R.drawable.bf)
                objectAnimator.pause()
            }
        }
        //??????????????????
        playerController.setOnPlayProgressListener(object :OnPlayProgressListener{
            override fun onPlayProgress(currPos: Long, duration: Long) {
                val values = duration / 100
                if (currPos < values || duration.toInt()==0) return
                val progress = currPos.toInt() * 100 / duration.toInt()
                binding.apply {
                    seekBar2.progress=progress
                    //????????????
                    textView10.text=currPos.toMinAndSeconds()
                    //?????????
                    textView11.text=playerController.getDuration().toMinAndSeconds()
//                    textView11.text="dada"
                    lyric.setCurrentTextSize(40f)
                    //??????????????????
                    lyric.updateTime(currPos)
                }
            }

        })

        // ??????????????????????????????
        binding.seekBar2.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                //????????????????????????
                if (fromUser) {
                    //??????????????????????????????????????????*??????/100???????????????????????????
                    val location: Long = (playerController.getDuration() * progress) / 100
                    println(location)
                    //??????????????????
                    binding.lyric.updateTime(location)
                    //?????????????????????????????????,??????????????????
                    playerController.seekTo(location)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

    }

    private  fun getsong(id: Int) {
        RetrofitClient.create(ApiService::class.java).getSongLyric(id).enqueue(object :
            Callback<SongLyric_Bean> {
            override fun onResponse(
                call: Call<SongLyric_Bean>,
                response: Response<SongLyric_Bean>
            ) {
                val bean=response.body()?.lrc?.lyric
                binding.lyric.loadLyric(bean)
                Log.d("gc",bean.toString())
            }

            override fun onFailure(call: Call<SongLyric_Bean>, t: Throwable) {

                t.printStackTrace()
            }

            })

        }





    companion object {
        // ??????????????????
        private const val DURATION_CD = 32_000L
        private const val ANIMATION_REPEAT_COUNTS = -1
        private const val ANIMATION_PROPERTY_NAME = "rotation"
    }

    //????????????
    private val objectAnimator: ObjectAnimator by lazy {
        ObjectAnimator.ofFloat(binding.discContainer, ANIMATION_PROPERTY_NAME, 0f, 360f).apply {
            interpolator = LinearInterpolator()
            duration = DURATION_CD
            repeatCount = ANIMATION_REPEAT_COUNTS
            start()
        }
    }
}












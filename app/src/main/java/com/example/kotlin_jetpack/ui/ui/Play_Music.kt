package com.example.kotlin_jetpack.ui.ui

import android.animation.ObjectAnimator
import android.content.Context
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
import com.example.kotlin_jetpack.Api.toMinAndSeconds
import com.example.kotlin_jetpack.R
import com.example.kotlin_jetpack.databinding.ActivityPlayMusicBinding
import com.example.kotlin_jetpack.ui.PlayMusicActivityModel

import com.example.kotlin_jetpack.ui.Unit.BaseActivity


import com.lzx.starrysky.OnPlayProgressListener
import com.lzx.starrysky.SongInfo
import com.lzx.starrysky.StarrySky

import jp.wasabeef.glide.transformations.BlurTransformation


class Play_Music : BaseActivity() {
    private val playerController = StarrySky.with()
    var mediaPlayerList: MutableList<SongInfo> = playerController.getPlayList()
    private lateinit var _binding: ActivityPlayMusicBinding
    val binding: ActivityPlayMusicBinding
        get() = _binding

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


        // 绑定歌词控件的样式
        // 绑定歌词控件的样式
        binding.lyric.apply {
            setLabel("暂无歌词")
            //设置非当前行歌词字体颜色 [normalColor]
            setNormalColor(R.color.xui_btn_green_normal_color)
            //设置拖动歌词时时间线的颜色
//            setTimelineColor(R.color.xui_config_color_white)
            //设置拖动歌词时右侧时间字体颜色
//            setTimeTextColor(R.color.xui_config_color_white)
            //设置拖动歌词时选中歌词的字体颜色
//            setTimelineTextColor(R.color.xui_config_color_white)
        }
    }
    //获取喜欢歌曲列表
    private fun love_song(urlid: Int) {
        val sp = getSharedPreferences("token", Context.MODE_PRIVATE)
        val tk=sp?.getString("cookie","www")
        val id=sp?.getInt("id",132819237)
        if (id != null) {
            play_viewhodel.apply {
                songlist.observe(this@Play_Music, Observer {
                    for (app in it){
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
            //歌词显示
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




            //上一首
            iamgLast.setOnClickListener {
                if(playerController.isPlaying()){

                    playerController.skipToPrevious()
                }else if (!playerController.isPlaying()){

                    playerController.skipToPrevious()
                }
            }

            imagKs.setOnClickListener {
                if (playerController.isPlaying()){
                    playerController.pauseMusic()
                }else{
                    playerController.restoreMusic()
                }
            }
            //下一首
            imagNext.setOnClickListener {
                if(playerController.isPlaying()){

                    playerController.skipToNext()
                    //歌词

                }else if (!playerController.isPlaying()){

                    playerController.skipToNext()

                }
            }

            //退出
            imageView8.setOnClickListener {
                finish()
                this@Play_Music.overridePendingTransition(
                    0,
                    R.anim.exit_animi
                )
            }

        }
    }

    //退出页面动画
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

        //监听当前播放状态
        playerController.playbackState().observe(this) {
            if (it.stage == "PLAYING" || it.stage == "PAUSE") {
                //获取当前音乐信息
                val item = playerController.getNowPlayingSongInfo()




                item?.let {
                    playerController.getNowPlayingSongInfo()?.songId?.let { getsong(it.toInt()) }
                    love_song(item.songId.toInt())
                    Log.d("get", item.artist)
                    //高斯模糊
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
        //设置歌曲进度
        playerController.setOnPlayProgressListener(object :OnPlayProgressListener{
            override fun onPlayProgress(currPos: Long, duration: Long) {
                val values = duration / 100
                if (currPos < values || duration.toInt()==0) return
                val progress = currPos.toInt() * 100 / duration.toInt()
                binding.apply {
                    seekBar2.progress=progress
                    //当前时长
                    textView10.text=currPos.toMinAndSeconds()
                    //总时长
                    textView11.text=playerController.getDuration().toMinAndSeconds()
//                    textView11.text="dada"
                    lyric.setCurrentTextSize(40f)
                    //刷新歌词位置
                    lyric.updateTime(currPos)
                }
            }

        })

        // 歌曲进度条变化的监听
        binding.seekBar2.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                //如果是由用户触发
                if (fromUser) {
                    //进度条变化刷新歌词位置（进度*总长/100）得到当前播放时长
                    val location: Long = (playerController.getDuration() * progress) / 100
                    println(location)
                    //刷新歌词位置
                    binding.lyric.updateTime(location)
                    //移动到媒体流中的新位置,以毫秒为单位
                    playerController.seekTo(location)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

    }

    private fun getsong(id: Int) {
        var lyric :String?=null
        play_viewhodel.apply {
            songlyric_list.observe(this@Play_Music, Observer {

                lyric=it.lyric
                Log.d("gc", lyric!!)

                binding.lyric.loadLyric(lyric)
            })

        }.getsonglyric_list(id)

    }

    companion object {
        // 动画循环时长
        private const val DURATION_CD = 32_000L
        private const val ANIMATION_REPEAT_COUNTS = -1
        private const val ANIMATION_PROPERTY_NAME = "rotation"
    }

    //旋转动画
    private val objectAnimator: ObjectAnimator by lazy {
        ObjectAnimator.ofFloat(binding.discContainer, ANIMATION_PROPERTY_NAME, 0f, 360f).apply {
            interpolator = LinearInterpolator()
            duration = DURATION_CD
            repeatCount = ANIMATION_REPEAT_COUNTS
            start()
        }
    }
}












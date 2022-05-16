package com.example.kotlin_jetpack.ui

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import com.bumptech.glide.Glide
import com.example.kotlin_jetpack.R
import com.example.kotlin_jetpack.databinding.FragmentMusicTabBinding
import com.example.kotlin_jetpack.ui.Unit.BaseFragment
import com.example.kotlin_jetpack.ui.ui.Play_Music
import com.lzx.starrysky.StarrySky

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MusicTabFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MusicTabFragment : BaseFragment() {

    companion object {
        // 动画循环时长
        private const val DURATION_CD = 32_000L
        private const val ANIMATION_REPEAT_COUNTS = -1
        private const val ANIMATION_PROPERTY_NAME = "rotation"
    }

    private lateinit var _binding:FragmentMusicTabBinding
    private val playerController=StarrySky.with()

    val binding: FragmentMusicTabBinding
        get() = _binding

    //旋转动画
    private val objectAnimator: ObjectAnimator by lazy {
        ObjectAnimator.ofFloat(
            binding.bflImag,
            ANIMATION_PROPERTY_NAME, 0f, 360f
        ).apply {
            interpolator = LinearInterpolator()
            duration = DURATION_CD
            repeatCount = ANIMATION_REPEAT_COUNTS
            start()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMusicTabBinding.inflate(inflater, container, false)
        binding.root.background.alpha=160
        return _binding.root
    }

    override fun initView() {
        super.initView()
        binding.imageView2.setOnClickListener {
            Log.d("bfl","6666")
        }
    }

    override fun initObserver() {
        super.initObserver()
        //监听当前播放状态
        playerController.playbackState().observe(this) {
            Log.d("back",it.errorMsg.toString()+it.stage.toString())
            if (it.stage == "PLAYING") {
                //获取当前音乐信息
                val item = playerController.getNowPlayingSongInfo()
                item?.let {

                    Glide.with(this).load(item.songCover).into(binding.bflImag)
                    binding.apply {
                        tvSongnane.text = item.songName
                        tvName.text = item.artist
                    }
                    binding.bfl.visibility = View.VISIBLE
                }
                binding.imageView2.setImageResource(R.drawable.zt)
                objectAnimator.resume()
            } else {
                binding.imageView2.setImageResource(R.drawable.bf)
                objectAnimator.pause()
            }
        }
    }

    override fun initListener() {
        super.initListener()
        binding.apply {
            //上一首
            imageView7.setOnClickListener {
                if(playerController.isPlaying()){

                    playerController.skipToPrevious()
                }else if (!playerController.isPlaying()){

                    playerController.skipToPrevious()
                }



                Log.d("sys",playerController.isPlaying().toString())
            }
            //暂停
            imageView2.setOnClickListener {
                if (playerController.isPlaying()) {
                    playerController.pauseMusic()
                } else {
                    playerController.restoreMusic()
                }
            }
            //下一首
            imageView6.setOnClickListener {
                if(playerController.isPlaying()){

                    playerController.skipToNext()
                }else if (!playerController.isPlaying()){

                    playerController.skipToNext()
                }
                Log.d("xys",playerController.getPlayList().size.toString())
            }
            bflImag.setOnClickListener {
                goPlayerPage()


            }
        }
    }
    //跳转到播放器界面
    private fun goPlayerPage(){
        if(playerController.getPlayList() != null){
            val intent=Intent(activity,Play_Music::class.java)
            startActivity(intent)



        }
    }

}



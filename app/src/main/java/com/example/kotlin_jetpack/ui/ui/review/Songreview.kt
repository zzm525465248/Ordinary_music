package com.example.kotlin_jetpack.ui.ui.review

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_jetpack.R
import com.example.kotlin_jetpack.adpter.SongReview_rv_Adapter
import com.example.kotlin_jetpack.adpter.SongSheet_rv_Adapter
import com.example.kotlin_jetpack.databinding.ActivityPlayMusicBinding
import com.example.kotlin_jetpack.databinding.ActivitySongreviewBinding
import com.example.kotlin_jetpack.databinding.FragmentGedansquare2Binding
import com.example.kotlin_jetpack.ui.song_list.Gedansquare2ViewModel
import com.lzx.starrysky.StarrySky
import kotlinx.coroutines.flow.collectLatest

class Songreview : AppCompatActivity() {
    private var _binding: ActivitySongreviewBinding?=null
    private val binding get() = _binding!!

    private  val viewModel by lazy {
        ViewModelProvider(this).get(songreview_viewmodel::class.java)
    }
    private val paging_rv_adapter by lazy {
        SongReview_rv_Adapter()

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivitySongreviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.tab_name.value= StarrySky.with().getNowPlayingSongId().toInt()
        val adapter = paging_rv_adapter
        binding.rv.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.rv.adapter=adapter

        lifecycleScope.launchWhenCreated {

            viewModel.loadMovie().collectLatest {

                adapter.submitData(it)

            }



        }
    }
}
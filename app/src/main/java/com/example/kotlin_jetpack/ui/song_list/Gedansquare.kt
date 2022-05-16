package com.example.kotlin_jetpack.ui.song_list

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kotlin_jetpack.R
import com.example.kotlin_jetpack.adpter.Paging_rv_adapter
import com.example.kotlin_jetpack.bean.Recommended_song_list_Bean
import com.example.kotlin_jetpack.bean.User_PlayList_Bean
import com.example.kotlin_jetpack.databinding.ActivityGedansquareBinding
import com.google.android.material.tabs.TabLayoutMediator
import com.gyf.barlibrary.ImmersionBar

class Gedansquare : AppCompatActivity() {
    private var _binding:ActivityGedansquareBinding ?=null
    private val fllist :MutableList<String> = mutableListOf()
     val recommended_song_list_view:MutableList<Recommended_song_list_Bean.Recommend> = mutableListOf()
    private val binding get() = _binding!!
    private  val viewModel by lazy {
        ViewModelProvider(this).get(GedansquareViewModel::class.java)
    }

    private val paging_rv_adapter by lazy {
        Paging_rv_adapter()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityGedansquareBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ImmersionBar.with(this).statusBarDarkFont(true).titleBar(binding.root).init()

        initview()
        initData()


    }

    private fun initData() {
        val sp = getSharedPreferences("token", Context.MODE_PRIVATE)
        val tk=sp?.getString("cookie","www")

        viewModel.apply {
            recommended_song_list.observe(this@Gedansquare, Observer {
                   recommended_song_list_view.addAll(it)
                Log.d("viuew",recommended_song_list_view.size.toString())
            })

        }.get_Recommended_song_list(tk.toString())
    }

    private fun initview() {
        viewModel.apply {
            songsheet_classification.observe(this@Gedansquare, Observer {
                fllist.add("推荐")


                for (app in it.tags){
                    fllist.add(app.name)
                }
//
                val pager =ScreenSlidePagerAdapter(this@Gedansquare)
                binding.viewpager.adapter=pager
                TabLayoutMediator(binding.tab,binding.viewpager){tab,index->
                    tab.text=fllist[index]
                }.attach()
                Log.d("fl",fllist.toString())

            })
        }.get_songsheet_fl()

    }
    private inner class ScreenSlidePagerAdapter(fa: Gedansquare) :FragmentStateAdapter(fa){
        override fun getItemCount(): Int {
         return   fllist.size
        }

        override fun createFragment(position: Int): Fragment {
//             when (position) {
//                position -> return Gedansquare1.newInstance(recommended_song_list_view, "www")
//                1 -> return Gedansquare2.newInstance(fllist[position], "lll")
//                2 -> return Gedansquare2.newInstance(fllist[position], "lll")
//                else ->  return Gedansquare2.newInstance("华语", "lll")
//            }
            if(position==0){
                return Gedansquare1.newInstance(recommended_song_list_view, "www")
            }else{
                return Gedansquare2.newInstance(fllist[position], "lll")
            }
        }
    }
}
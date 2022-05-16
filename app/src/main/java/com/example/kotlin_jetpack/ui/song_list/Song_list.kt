package com.example.kotlin_jetpack.ui.song_list

import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.kotlin_jetpack.Api.AppBarStateChangeListener
import com.example.kotlin_jetpack.adpter.Paging_rv_adapter
import com.example.kotlin_jetpack.databinding.ActivitySongListBinding
import com.example.kotlin_jetpack.ui.Unit.goneAlphaAnimation
import com.example.kotlin_jetpack.ui.Unit.visibleAlphaAnimation
import com.google.android.material.appbar.AppBarLayout
import com.gyf.barlibrary.ImmersionBar
import jp.wasabeef.glide.transformations.BlurTransformation
import kotlinx.coroutines.flow.collect

import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class Song_list : AppCompatActivity() {
    var bt:String=""
  public  val list= mutableListOf<Int>()

    private val homeViewModel by lazy {
        ViewModelProvider(this).get(SonglistViewModer::class.java)
    }

    private val paging_rv_adapter by lazy {
        Paging_rv_adapter()

    }

    private var _binding: ActivitySongListBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_song_list)
        _binding= ActivitySongListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        homeViewModel.id.value=intent.getLongExtra("id",0)
        initview(intent.getLongExtra("id",0))
        initapptabar()
        songlist()

    }

    private fun songlist() {

        val manager = LinearLayoutManager(this)
        binding.rv.layoutManager = manager
        val adapter = paging_rv_adapter
        binding.rv.adapter=adapter

//        paging_rv_adapter.setOnItemClickListener(object :OnRecyItemClickListener{
//            override fun onClick(view: View?, position: Int,id:Int) {
//                Log.d("post",id.toString())
//
//            }
//        })
        lifecycleScope.launchWhenCreated {
            homeViewModel.loadMovie().collectLatest {
                adapter.submitData(it)
            }
        }

//            homeViewModel.apply {
//            songsheet_list.observe(this@Song_list, Observer {
//                val list1: MutableList<Song1> = mutableListOf()
//                list1.addAll(it)
//                Log.d("list1",list1.size.toString())
////                binding.rv.setup<Song1> {
////                    dataSource(list1)
////                }
//            })
//        }.get_list(2146128,0)
    }
    fun getsong(id:Int) {
        homeViewModel.apply {
            songlist.observe(this@Song_list, Observer {
               Log.d("song",it[0].url)
            })

        }.Song_List(id)
    }

//    fun getsong_List(id:String){
//        homeViewModel.apply {
//            songlist.observe(this@Song_list, Observer {
//                Log.d("list",it.size.toString())
//            })
//        }.SongURl_List(list)
//    }

    private fun initapptabar() {
        binding.appbar.addOnOffsetChangedListener(object :AppBarStateChangeListener(){
            override fun onStateChanged(appBarLayout: AppBarLayout?, state: State?) {
                //展开
                if(state==State.EXPANDED){
                    binding.userLayout.visibleAlphaAnimation()
                    binding.toolbar.goneAlphaAnimation()

                    Log.d("zk","zk")

                }else if(state==State.COLLAPSED){
                    //关闭
                    binding.userLayout.goneAlphaAnimation()
                    binding.toolbar.visibleAlphaAnimation()
                    binding.toolbar.title=bt
                    Log.d("zk",bt)
                }else{
                    binding.toolbar.goneAlphaAnimation()

                    Log.d("zk","zt")
                }

            }
        })
    }

    private fun initview(id: Long) {
      //  ImmersionBar.with(this).statusBarDarkFont(true).titleBar(binding.root).init()
        ImmersionBar.with(this).statusBarDarkFont(true).init()
        homeViewModel.apply {
            songsheet_details.observe(this@Song_list, Observer {
                //高斯模糊
                Log.d("log",it.name)
                val optionsBlur = RequestOptions().transform(BlurTransformation(15, 20))
                Glide.with(this@Song_list).load(it.coverImgUrl).apply(optionsBlur).into(binding.tabbarImg)
                Glide.with(this@Song_list).load(it.coverImgUrl).into(binding.sheetImg)

                binding.apply {
                    sheetName.text=it.name
                    Glide.with(this@Song_list).load(it.creator.avatarUrl).into(sheetImg)

                    sheetUserName.text=it.creator.nickname
                    shhetJj.text=it.creator.signature
                    bt=it.name

                  val  size = it.trackCount
                    homeViewModel.size.value=it.trackCount
                    textView19.setText(Html.fromHtml("播放更多<font color=\"#94C2BFBF\"><small> ($size)</small></font>"))

                }
            })
        }.getdetails(id)
    }
}



package com.example.kotlin_jetpack.ui.ui.dashboard

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.edit
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.kotlin_jetpack.Api.ApiService
import com.example.kotlin_jetpack.Api.AppBarStateChangeListener
import com.example.kotlin_jetpack.R
import com.example.kotlin_jetpack.bean.Song
import com.example.kotlin_jetpack.bean.Song_details_Bean
import com.example.kotlin_jetpack.databinding.ActivityLoveListBinding
import com.example.kotlin_jetpack.databinding.ActivitySongListBinding
import com.example.kotlin_jetpack.ui.Unit.goneAlphaAnimation
import com.example.kotlin_jetpack.ui.Unit.visibleAlphaAnimation
import com.example.kotlin_jetpack.ui.song_list.SonglistViewModer
import com.google.android.material.appbar.AppBarLayout
import com.gyf.barlibrary.ImmersionBar
import com.lzx.library.addItem
import com.lzx.library.setText
import com.lzx.library.setup
import com.lzx.starrysky.SongInfo
import com.lzx.starrysky.StarrySky
import jp.wasabeef.glide.transformations.BlurTransformation
import kotlin.math.log

class Love_List : AppCompatActivity() {
    val list= mutableListOf<Int>()
    val list2= mutableListOf<Song_details_Bean.Song>()
    val songurl_list : MutableList<Int> = mutableListOf()
    val songurl_list2 : MutableList<Int> = mutableListOf()
    private val playerController= StarrySky.with()
    var bj=false

    private var _binding: ActivityLoveListBinding? = null
    private val binding get() = _binding!!

    private val homeViewModel by lazy {
        ViewModelProvider(this).get(loveViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_love_list)
        _binding= ActivityLoveListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ImmersionBar.with(this).statusBarDarkFont(true).init()
        val sp = getSharedPreferences("token", Context.MODE_PRIVATE)
        Glide.with(this@Love_List).load(sp.getString("imag",null)).into(binding.sheetUserImag)
        binding.sheetUserName.text=sp.getString("name",null)

        if(sp.getString("sheet_imag","null")=="null"){
            Toast.makeText(this,"加载中",Toast.LENGTH_LONG).show()
            bj=true
        }else{
            val optionsBlur = RequestOptions().transform(BlurTransformation(15, 20))
            Glide.with(this@Love_List).load(sp.getString("sheet_imag","null")).apply(optionsBlur).into(binding.tabbarImg)
            Glide.with(this@Love_List).load(sp.getString("sheet_imag","null")).into(binding.sheetImg)
        }

        val tk=sp?.getString("cookie","www")
        val id=sp?.getInt("id",132819237)

        if (id != null) {
            iniview(id.toInt(),tk.toString())
        }

     //   rvadapter()
        initapptabar()
        getsongurl()
    }

    private fun getsongurl() {
        binding.textView19.setOnClickListener {
            val infolist :MutableList<SongInfo> = mutableListOf()

            for (app in list2){
                if (infolist.size<=30){
                    songurl_list.add(app.id)
                    val info=SongInfo()
                    info.songName=app.name
                    info.artist=app.ar[0].name
                    info.songUrl= ApiService.SONG_URL+app.id+".mp3"
                    info.songCover=app.al.picUrl
                    info.songId=app.id.toString()

                    infolist.add(info)
                }

            }
            playerController.playMusic(infolist,0)



//            homeViewModel.apply {
//                song_url.observe(this@Love_List, Observer {
//
//
//                    for ((index,value) in it.withIndex()){
//
//                        if(value?.url==null||value?.id!=list2[index].id.toLong()){
//                            continue
//                        }else{
//                            val info=SongInfo()
//                            info.songName=list2[index].name
//                            info.artist=list2[index].ar[0].name
//                            info.songUrl=it[index].url
//                            info.songCover=list2[index].al.picUrl
//                            info.songId=value.id.toString()
//                            Log.d("11",it[index].id.toString())
//                            infolist.add(info)
//                        }
//
//                    }
//                    Log.d("11",it[0].url)
//                    Log.d("11",it[0].id.toString())
//
//
//                    playerController.playMusic(infolist,0)
//
////                    playerController.addPlayList(infolist)
//                })
//            }.getUrl(songurl_list.toString().replace("[","").replace("]",""))

        }
    }

    private fun rvadapter() {
        binding.rv.setup<Song_details_Bean.Song> {
            dataSource(list2)
            withLayoutManager { LinearLayoutManager(this@Love_List,LinearLayoutManager.HORIZONTAL,false) }
            adapter {
                addItem(R.layout.sheet_rv){
                    isForViewType { data, _ -> data != null }
                    bindViewHolder { data, position, holder ->
                        setText(
                            R.id.textView16,
                            data?.name
                        )

                    }
                }
            }
        }
    }

    private fun getlovelist(list: String) {
        homeViewModel.apply {
            lovelist.observe(this@Love_List, Observer {

                list2.addAll(it)

                binding.rv.setup<Song_details_Bean.Song> {
                    dataSource(list2)
                    withLayoutManager { LinearLayoutManager(this@Love_List,LinearLayoutManager.VERTICAL,false) }
                    adapter {
                        addItem(R.layout.sheet_rv){
                            isForViewType { data, _ -> data != null }
                            bindViewHolder { data, position, holder ->
                                setText(
                                    R.id.textView16,
                                    data?.name
                                )
                                setText(
                                    R.id.textView15,
                                    (position+1).toString()
                                )
                                setText(
                                    R.id.tv_songname,
                                    data?.ar?.get(0)?.name
                                )
                            }
                        }
                    }
                }

                if(bj){
                    val optionsBlur = RequestOptions().transform(BlurTransformation(15, 20))
                    Glide.with(this@Love_List).load(it[0].al.picUrl).apply(optionsBlur).into(binding.tabbarImg)
                    Glide.with(this@Love_List).load(it[0].al.picUrl).into(binding.sheetImg)
                }

                getSharedPreferences("token",Context.MODE_PRIVATE).edit{
                    putString("sheet_imag",it[0].al.picUrl)
                }

            })
        }.getlove_details(list)
    }

    private fun iniview(id:Int,tk:String) {
        homeViewModel.apply {
            songlist.observe(this@Love_List, Observer {
                list.addAll(it)
                val s1=  list.toString().replace("[","").replace("]","")
                Log.d("s",s1)
                getlovelist(s1)


            })
        }.getlist(id,tk)
    }

    private fun initapptabar() {
        binding.appbar.addOnOffsetChangedListener(object : AppBarStateChangeListener(){
            override fun onStateChanged(appBarLayout: AppBarLayout?, state: State?) {
                //展开
                if(state== State.EXPANDED){
                    binding.userLayout.visibleAlphaAnimation()

                }else if(state== State.COLLAPSED){
                    //关闭
                    binding.userLayout.goneAlphaAnimation()

                }else{
                    binding.toolbar.title=""
                }

            }
        })
    }
}
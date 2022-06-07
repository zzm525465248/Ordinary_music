package com.example.kotlin_jetpack.ui.ui.home


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.ethanhua.skeleton.Skeleton
import com.example.kotlin_jetpack.Api.ApiService
import com.example.kotlin_jetpack.R
import com.example.kotlin_jetpack.adpter.SongListAdapter
import com.example.kotlin_jetpack.bean.*
import com.example.kotlin_jetpack.databinding.FragmentHomeBinding

import com.example.kotlin_jetpack.ui.song_list.Gedansquare
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.navigation.NavigationView
import com.lzx.library.*
import com.lzx.starrysky.SongInfo
import com.lzx.starrysky.StarrySky
import com.youth.banner.loader.ImageLoader
import kotlin.math.log


class HomeFragment : Fragment() {
    private val playerController=StarrySky.with()
    val list: MutableList<List<Resource>> = mutableListOf()
    val new_list: MutableList<List<Resource>> = mutableListOf()


    private val homeViewModel by lazy {
        ViewModelProvider(this).get(HomeViewModel::class.java)
    }

    private var _binding: FragmentHomeBinding? = null

    private val songListadapter by lazy {
        SongListAdapter()

    }

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {


        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        initview()
        initObserver()
        initsonglist()
        inithomelist()
        getqbfw()
//        binding.button.setOnClickListener {
//            val intent= Intent(activity, Song_list::class.java)
//            startActivity(intent)
//        }
        right_bt()


        return root
    }





    private fun right_bt() {
       binding.apply {
           //新歌推荐 播放全部
           button3.setOnClickListener {
               val list = mutableListOf<Int>()

               for (app in new_list[0]){
                 list.add(app.resourceExtInfo.songData.id)
               }
               for (app in new_list[1]){
                   list.add(app.resourceExtInfo.songData.id)
               }



               homeViewModel.apply {
                   songdetails_list.observe(viewLifecycleOwner, Observer {
                       Log.d("list",it.size.toString())
                       val infolist :MutableList<SongInfo> = mutableListOf()

                       for (app in it){
                         //  songurl_list.add(app.id)
                           val info=SongInfo()
                           info.songName=app.name
                           info.artist=app.ar[0].name
                           info.songUrl= ApiService.SONG_URL+app.id+".mp3"
                           info.songCover=app.al.picUrl
                           info.songId=app.id.toString()

                           infolist.add(info)
                       }
                       playerController.playMusic(infolist,0)
                   })
               }.getUrl_list(list.toString().replace("[","").replace("]",""))
           }
           button.setOnClickListener {
               val Intent = Intent(activity,Gedansquare::class.java)
               activity?.startActivity(Intent)

           }
           imageView9.setOnClickListener {
               draw.openDrawer(GravityCompat.START)
           }
       }
    }




    private fun initview() {
        binding.rv.run {
            layoutManager =LinearLayoutManager(this@HomeFragment.activity,LinearLayoutManager.HORIZONTAL,false)
            adapter=songListadapter
        }
        val headerLayout = binding.navView.getHeaderView(0)
        val bj:ImageView=headerLayout.findViewById(R.id.imageView18)
        val tx:ShapeableImageView=headerLayout.findViewById(R.id.shapeableImageView3)
        val name:TextView=headerLayout.findViewById(R.id.textView30)
        val jj:TextView=headerLayout.findViewById(R.id.textView31)
        val sp= context?.getSharedPreferences("token",Context.MODE_PRIVATE)
        name.text=sp?.getString("name","暂无")
        jj.text=sp?.getString("jj","cool~")
        Glide.with(this).load(sp?.getString("backgroundUrl",null)).into(bj)
        Glide.with(this).load(sp?.getString("tx",null)).into(tx)

        binding.navView.setNavigationItemSelectedListener (NavigationView.OnNavigationItemSelectedListener {
            it.setCheckable(true)
            return@OnNavigationItemSelectedListener true
        })

    }

    private fun initsonglist() {
       homeViewModel.apply {
           recommendedsonglist.observe(viewLifecycleOwner, Observer {

               songListadapter.setData(it)
           })
       }.RecommendedSongList()
    }

    private fun inithomelist(){
        homeViewModel.apply {
            homelist.observe(viewLifecycleOwner, Observer {
                Log.d("home",it[2].uiElement.subTitle.title)

                for (i in it[2].creatives){
                    list.add(i.resources)

                }
//                for (e in it[2].creatives){
//                    list_url.add(e.resources[0].resourceExtInfo.song.id)
//                    list_url.add(e.resources[1].resourceExtInfo.song.id)
//                    list_url.add(e.resources[2].resourceExtInfo.song.id)
//
//
//                }

                for (i in it[3].creatives){
                    new_list.add(i.resources)
                }

                rvadpter()
                newadapter()

                binding.apply {
                    textView2.text=it[1].uiElement.subTitle.title
                    textView6.text=it[2].uiElement.subTitle.title
                    textView14.text=it[3].creatives[0].uiElement.mainTitle.title
                }

            })

        }.Home_List()
    }

    //新歌推荐
    private fun newadapter() {
            binding.newRv.setup<List<Resource>> {
                dataSource(new_list)
                withLayoutManager { GridLayoutManager(context,3,GridLayoutManager.HORIZONTAL,false) }
                adapter {
                    addItem(R.layout.newsong_rv){
                        isForViewType { data, _ -> data != null }
                        bindViewHolder { data, position, holder ->
                            setText(R.id.new_song,
                                data?.get(0)?.uiElement?.mainTitle?.title
                                )
                            setText(R.id.new_name,
                                data?.get(0)?.resourceExtInfo?.artists?.get(0)?.name
                            )
                            setText(R.id.new_sq,
                                data?.get(0)?.uiElement?.subTitle?.title
                            )
                            val cly=findViewById<ConstraintLayout>(R.id.new_song_cl)
                            val imag=findViewById<ImageView>(R.id.new_imag)
                            Glide.with(context).load(data?.get(0)?.uiElement?.image?.imageUrl).into(imag)
//                            holder.itemClicked{
//                                Log.d("id", data?.get(0)?.resourceExtInfo?.songData?.id.toString())
//                                Log.d("id", data?.get(0)?.resourceExtInfo?.songData?.name!!)
//                                Log.d("new","www")
//                            }

                            cly.setOnClickListener {
                                Log.d("id", data?.get(0)?.resourceExtInfo?.songData?.id.toString())
                                Log.d("id", data?.get(0)?.resourceExtInfo?.songData?.name!!)

                               if (data!=null){
                                   val id=data.get(0).resourceExtInfo.songData.id
                                   Log.d("id", id.toString())
                                   val info =SongInfo()
                                info.songId= id.toString()
                                info.songUrl=ApiService.SONG_URL+id+".mp3"
                                info.songName= data.get(0).resourceExtInfo.songData.name
                                info.songCover=data.get(0).uiElement.image.imageUrl
                                info.artist="- "+data?.get(0)?.resourceExtInfo?.artists?.get(0)?.name

                                if(playerController.getPlayList().isEmpty()){
                                    playerController.playMusicByInfo(info)
                                }else{
                                    playerController.addSongInfo(info)

                                    Log.d("size",playerController.getPlayList().size.toString())
                                    for (app in playerController.getPlayList() ){
                                        Log.d("for",app.songName)
                                    }
                                }
                               }

                            }


                        }

                    }
                }
            }
    }


    //观察数据变化
    private fun initObserver() {
        homeViewModel.apply {
            banner_list.observe(viewLifecycleOwner, Observer {
                val list= arrayListOf<String>()
                for (app in it){
                    list.add(app.pic)
                }

                binding.banner.setImageLoader(MyLoader())
                    .setImages(list).start()
            })
        }.Banner_home()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private inner class MyLoader : ImageLoader() {
        override fun displayImage(context: Context, path: Any, imageView: ImageView) {
            Glide.with(context).load(path as String).into(imageView)
        }
    }


    //推荐歌曲
    private fun rvadpter() {
        binding.songRv.setup<List<Resource>> {
            dataSource(list)
            withLayoutManager {LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false) }
            adapter {
                addItem(R.layout.song_rv) {
                    isForViewType { data, _ -> data != null }
                    bindViewHolder { data, position, holder  ->
                        setText(R.id.textView,
                            data?.get(0)?.uiElement?.mainTitle?.title
                        )
                        setText(R.id.textView4,
                            "- "+data?.get(0)?.resourceExtInfo?.artists?.get(0)?.name
                        )
                        setText(R.id.textView5,data?.get(0)?.uiElement?.subTitle?.title)
                        setTextColor(R.id.textView5,R.color.yellow)

                        setText(R.id.textView7,data?.get(1)?.uiElement?.mainTitle?.title)
                        setText(R.id.textView8,
                            "- "+data?.get(1)?.resourceExtInfo?.artists?.get(0)?.name
                        )
                        setText(R.id.textView9,data?.get(1)?.uiElement?.subTitle?.title)
                        setTextColor(R.id.textView9,R.color.yellow)
                        val imag=findViewById<ShapeableImageView>(R.id.songimag)
                        val imag2=findViewById<ShapeableImageView>(R.id.imageView4)
                        imag.setOnClickListener {
                            Log.d("bt",data?.get(0)?.resourceExtInfo?.song?.id.toString())
                           val id=data?.get(0)?.resourceExtInfo?.song?.id
                           if(id!=null){
                               val info =SongInfo()
                               info.songId= id.toString()
                               info.songUrl=ApiService.SONG_URL+id+".mp3"
                               info.songName= data?.get(0)?.uiElement?.mainTitle?.title
                               info.songCover=data?.get(0)?.uiElement?.image?.imageUrl
                               info.artist="- "+data?.get(0)?.resourceExtInfo?.artists?.get(0)?.name



                               if(playerController.getPlayList().isEmpty()){
                                   playerController.playMusicByInfo(info)
                               }else{
                                  playerController.addSongInfo(info)

                                   Log.d("size",playerController.getPlayList().size.toString())
                                   for (app in playerController.getPlayList() ){
                                       Log.d("for",app.songName)
                                   }
                               }
                           }

                        }
                        imag2.setOnClickListener {
                            val id=data?.get(1)?.resourceExtInfo?.song?.id
                            if(id!=null){
                                val info =SongInfo()
                                info.songId= id.toString()
                                info.songUrl=ApiService.SONG_URL+id+".mp3"
                                info.songName= data?.get(1)?.uiElement?.mainTitle?.title
                                info.songCover=data?.get(1)?.uiElement?.image?.imageUrl
                                info.artist="- "+data?.get(1)?.resourceExtInfo?.artists?.get(0)?.name
                                Log.d("size",playerController.getPlayList().size.toString())

                                if(playerController.getPlayList().isEmpty()){
                                    playerController.playMusicByInfo(info)
                                }else{
                                    playerController.addSongInfo(info)

                                    Log.d("size",playerController.getPlayList().size.toString())
                                    for (app in playerController.getPlayList() ){
                                        Log.d("for",app.songName)
                                    }

                                }

                            }
                        }
                        Glide.with(context).load(data?.get(0)?.uiElement?.image?.imageUrl).into(imag)
                        Glide.with(context).load(data?.get(1)?.uiElement?.image?.imageUrl).into(imag2)


                        Log.d("get",position.toString())

                    }
                }
            }
        }
    }

     fun getsong(id:Int) {
        homeViewModel.apply {
            songlist.observe(viewLifecycleOwner, Observer {
                Log.d("id",id.toString()+"www")


                Log.d("id",it[0].level+"jjj")
            })

        }.Song_List(id)
    }

    private fun getqbfw(){
        homeViewModel.apply {
            qbfwlist.observe(viewLifecycleOwner, Observer {
                Log.d("qbfw",it[0].name)
                val list1: MutableList<Datas> = mutableListOf()
               list1.addAll(it)

                binding.qbfwRv.setup<Datas> {
                    dataSource(list1)
                    withLayoutManager {LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false) }
                    adapter {
                        addItem(R.layout.qbfw_view){
                            isForViewType { data, _ -> data != null }
                            bindViewHolder { data, position, holder ->
                                if (data != null) {
                                    setText(
                                        R.id.textView13,
                                        data.name
                                    )
                                    val imag=findViewById<ImageView>(R.id.imageView11)
                                    Glide.with(context).load(data.iconUrl).into(imag)
                                }
                            }
                        }
                    }
                }
            })
        }.Qbfw_home()
    }


}













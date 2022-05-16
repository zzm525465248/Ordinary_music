package com.example.kotlin_jetpack.ui.ui.dashboard

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.kotlin_jetpack.bean.User_PlayList_Bean
import com.example.kotlin_jetpack.databinding.FragmentDashboardBinding
import com.google.android.material.tabs.TabLayoutMediator
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class DashboardFragment : Fragment() {

    private lateinit var viewpager:ViewPager2
    private var s1list:MutableList<User_PlayList_Bean.Playlist> = mutableListOf()
    private  var s2list: MutableList<User_PlayList_Bean.Playlist> = mutableListOf()

    private var _binding: FragmentDashboardBinding? = null
  private  val dashboardViewModel by lazy {
      ViewModelProvider(this).get(DashboardViewModel::class.java)
  }

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val sp= context?.getSharedPreferences("token",Context.MODE_PRIVATE)
        val tk=sp?.getString("cookie","www")
        val id=sp?.getInt("id",132819237)

        Log.d("id",id.toString())
        iniview()
        getUser_List(tk.toString(),id!!.toInt())
        getplay_List(id)
        return root
    }



    private fun getplay_List(id: Int) {
        dashboardViewModel.apply {
            playlist.observe(viewLifecycleOwner, Observer {
             //  s1list.addAll(it)


                for ((index,value ) in it.playlist.withIndex()){

                    if ( value.ordered){
                        s2list.add(value)

                    }else if(!value.ordered &&index!=0){
                        s1list.add(value)
                    }
                }




                binding.apply {
                    Glide.with(this@DashboardFragment).load(it.playlist[0].coverImgUrl).into(shapeableImageView)
                    textView24.text=it.playlist[0].trackCount.toString()+"首,已下载"+it.playlist[0].cloudTrackCount+"首"
                    val list=ArrayList<String>(2)
                    list.add("创建歌单")
                    list.add("收藏歌单")
                    val pagerAdapter=ScreenSlidePagerAdapter(this@DashboardFragment)
                    binding.viewpager.adapter=pagerAdapter
                    TabLayoutMediator(tabLayout,viewpager){tab,index->
                        tab.text=list[index]
                    }.attach()
                }

            })
        }.getplaylist(id)
    }



    private fun iniview() {
            binding.shapeableImageView.setOnClickListener {
                val intent=Intent(context,Love_List::class.java)
                startActivity(intent)
            }

    }

    fun getUser_List(cookie:String,id:Int){
        dashboardViewModel.apply {
            userlist.observe(viewLifecycleOwner, Observer {

                binding.apply {
                    Log.d("id",it.level.toString())
                    Glide.with(this@DashboardFragment).load(it.profile.avatarUrl).into(userImag)
                    textView21.text=it.profile.nickname
                    t1.text=it.profile.follows.toString()+"关注"
                    t2.text=it.profile.followeds.toString()+"粉丝"
                    t3.text="Lv."+it.level

                }
            })
        }.getuser(cookie,id)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    //adapter内部类
    private inner class  ScreenSlidePagerAdapter(fa:DashboardFragment) :FragmentStateAdapter(fa){
        override fun getItemCount(): Int {
            return 2
        }

        override fun createFragment(position: Int): Fragment{
            if (position==0){
//                return  Fragment1(s1list,"创建歌单")
                return Fragment1.newInstance(s1list,"创建歌单")
            }else{
                return  Fragment1.newInstance(s2list,"收藏歌单")
            }

        }
    }
}
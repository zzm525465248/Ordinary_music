package com.example.kotlin_jetpack.ui.song_list

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.kotlin_jetpack.R
import com.example.kotlin_jetpack.bean.Recommended_song_list_Bean
import com.example.kotlin_jetpack.bean.User_PlayList_Bean
import com.example.kotlin_jetpack.databinding.ActivityGedansquareBinding
import com.example.kotlin_jetpack.databinding.FragmentGedansquare1Binding

import com.google.android.material.imageview.ShapeableImageView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.lzx.library.addItem
import com.lzx.library.setText
import com.lzx.library.setup

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Gedansquare1.newInstance] factory method to
 * create an instance of this fragment.
 */
class Gedansquare1 : Fragment() {
    private var _binding: FragmentGedansquare1Binding?=null
    private val binding get() = _binding!!
    // TODO: Rename and change types of parameters

  private  var param1:List<Recommended_song_list_Bean.Recommend> = mutableListOf()
    private var param2: String? = null

    private  val viewModel by lazy {
        ViewModelProvider(this).get(GedansquareViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val type= object : TypeToken<MutableList<Recommended_song_list_Bean.Recommend?>?>() {}.type
        arguments?.let {
            param1=Gson().fromJson(it.getString(ARG_PARAM1),type)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentGedansquare1Binding.inflate(inflater, container, false)
        initData()
     //   initview()
        val root: View = binding.root
   //     binding.textView27.text=param1[0].name


        return root
    }

    private fun initview() {
        binding.apply {
            textView27.text="宝藏歌单~"
           rv.setup<Recommended_song_list_Bean.Recommend> {
                dataSource(param1 as MutableList<Recommended_song_list_Bean.Recommend>)
                withLayoutManager { GridLayoutManager(context,4,GridLayoutManager.VERTICAL,false) }
                adapter {
                    addItem(R.layout.rv_test){
                        isForViewType { data, _ -> data != null }
                        bindViewHolder { data, position, holder ->
                            setText(R.id.tv_name,
                            data?.name)
                            setText(R.id.textView3,
                              (data?.playcount!! /10000).toString()+"万")
                            val imag=findViewById<ShapeableImageView>(R.id.imag)
                            Glide.with(context).load(data?.picUrl).into(imag)
                        }
                    }
                }
            }
        }
    }
    private fun initData() {
        val sp =activity?.getSharedPreferences("token", Context.MODE_PRIVATE)
        val tk=sp?.getString("cookie","www")

        viewModel.apply {
            recommended_song_list.observe(viewLifecycleOwner, Observer {
                binding.apply {
                    textView27.text="宝藏歌单~"
                    rv.setup<Recommended_song_list_Bean.Recommend> {
                        dataSource(it as MutableList<Recommended_song_list_Bean.Recommend>)
                        withLayoutManager { GridLayoutManager(context,3,GridLayoutManager.VERTICAL,false) }
                        adapter {
                            addItem(R.layout.rv_test){
                                isForViewType { data, _ -> data != null }
                                bindViewHolder { data, position, holder ->
                                    setText(R.id.tv_name,
                                        data?.name)
                                    setText(R.id.textView3,
                                        (data?.playcount!! /10000).toString()+"万")
                                    val imag=findViewById<ShapeableImageView>(R.id.imag)
                                    Glide.with(context).load(data?.picUrl).into(imag)


                                }
                            }
                        }
                    }
                }
                Log.d("viuew",it.size.toString())
            })

        }.get_Recommended_song_list(tk.toString())
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Gedansquare1.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: MutableList<Recommended_song_list_Bean.Recommend>, param2: String) =
            Gedansquare1().apply {
                arguments = Bundle().apply {
                    val s1: String? = Gson().toJson(param1)
                    putString(ARG_PARAM1,s1)


                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
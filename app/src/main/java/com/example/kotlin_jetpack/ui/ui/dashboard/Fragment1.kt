package com.example.kotlin_jetpack.ui.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.kotlin_jetpack.R
import com.example.kotlin_jetpack.bean.User_PlayList_Bean
import com.example.kotlin_jetpack.databinding.Fragment1Binding
import com.example.kotlin_jetpack.ui.song_list.Song_list
import com.google.android.material.imageview.ShapeableImageView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.lzx.library.*
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment1.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment1 : Fragment() {

    private var _binding: Fragment1Binding? = null
    private val binding get() = _binding!!
    // TODO: Rename and change types of parameters
//    private var param1:MutableList<User_PlayList_Bean.Playlist> =s
    private var param1:List<User_PlayList_Bean.Playlist> ?=null

   private var param2: String? =null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val type= object :TypeToken<MutableList<User_PlayList_Bean.Playlist?>?>() {}.type
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
        _binding = Fragment1Binding.inflate(inflater, container, false)


        binding.textView25.text=param2+"("+param1?.size.toString()+"首)"
        binding.playlistRv.setup<User_PlayList_Bean.Playlist> {
            dataSource(param1 as MutableList<User_PlayList_Bean.Playlist>)
            withLayoutManager { LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false) }
            adapter {
                addItem(R.layout.playlist_view){
                    isForViewType { data, _ -> data != null }
                    bindViewHolder { data, position, holder ->
                        setText(R.id.play_name,
                        data?.name)
                        setText(R.id.textView26,
                        data?.trackCount.toString()+"首 by "+data?.creator?.nickname)
                        val imag=findViewById<ShapeableImageView>(R.id.play_imag)
                        Glide.with(this@Fragment1).load(data?.coverImgUrl).into(imag)
                        itemClicked(listener = View.OnClickListener {
                            val intent= Intent(context, Song_list::class.java)
                            intent.putExtra("id",data?.id)
                            startActivity(intent)
                        })
                    }


                }
            }
        }
        val root: View = binding.root
        return root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Fragment1.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: MutableList<User_PlayList_Bean.Playlist>, param2: String) =
            Fragment1().apply {
                arguments = Bundle().apply {
                  //  putString(ARG_PARAM1,Json.)


                 //   val type = object : TypeToken<List<Student?>?>() {}.type
                    val s1: String? =Gson().toJson(param1)
                    putString(ARG_PARAM1,s1)

                    putString(ARG_PARAM2, param2)
                }
            }


    }
}
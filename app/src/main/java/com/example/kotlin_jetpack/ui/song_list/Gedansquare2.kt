package com.example.kotlin_jetpack.ui.song_list

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kotlin_jetpack.adpter.PersonLoadStateAdapter
import com.example.kotlin_jetpack.adpter.SongSheet_rv_Adapter
import com.example.kotlin_jetpack.databinding.FragmentGedansquare2Binding
import kotlinx.coroutines.flow.collectLatest
import java.util.*
import kotlin.concurrent.fixedRateTimer
import kotlin.concurrent.timerTask

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Gedansquare2.newInstance] factory method to
 * create an instance of this fragment.
 */
class Gedansquare2 : Fragment() {
    private var _binding: FragmentGedansquare2Binding?=null
    private val binding get() = _binding!!
    private var param1: String? = null
    private var param2: String? = null



    private  val viewModel by lazy {
        ViewModelProvider(this).get(Gedansquare2ViewModel::class.java)
    }
    private val paging_rv_adapter by lazy {
        SongSheet_rv_Adapter()

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        viewModel.tab_name.value= param1
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGedansquare2Binding.inflate(inflater, container, false)
        val adapter = paging_rv_adapter


        binding.rv.adapter= adapter.withLoadStateFooter(PersonLoadStateAdapter(context))


        binding.rv.layoutManager=GridLayoutManager(activity,3,GridLayoutManager.VERTICAL,false)






        lifecycleScope.launchWhenCreated {

            viewModel.loadMovie().collectLatest {

                adapter.submitData(it)

            }



        }



       // initdata(manager)

//        lifecycleScope.launch {
//            viewModel.get_songsheet_paging(param1.toString()).collectLatest {
//                paging_rv_adapter.submitData(it)
//
//            }
//        }
        val root: View = binding.root
        // Inflate the layout for this fragment

        return root
    }

//    private fun initdata( manager:GridLayoutManager) {
//        viewModel.apply {
//            songsheet_list.observe(viewLifecycleOwner, Observer {
//                if (it.more){
//                    viewModel.page.value= viewModel.page.value?.plus(50)
//                }
//                Log.d("size",it.playlists.size.toString())
//
//                binding.rv.setup<SongSheetList_Bean.Playlists> {
//                    dataSource(it.playlists as MutableList<SongSheetList_Bean.Playlists>)
//                    withLayoutManager {manager }
//                    adapter {
//                        addItem(R.layout.rv_test){
//                            isForViewType { data, _ -> data != null }
//                            bindViewHolder { data, position, holder ->
//                                setText(R.id.tv_name,
//                                    data?.name)
//                                setText(R.id.textView3,
//                                    (data?.playCount!! /10000).toString()+"万")
//                                val imag=findViewById<ShapeableImageView>(R.id.imag)
//                                Glide.with(context).load(data?.coverImgUrl).into(imag)
//
//                            }
//                        }
//
//                        binding.rv.addOnScrollListener(rv(manager,))
//                    }
//                }
//            })
//        }.get(param1.toString())
//
//
//    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Gedansquare2.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Gedansquare2().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


//    private inner class rv(val manager:GridLayoutManager): RecyclerView.OnScrollListener() {
//        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//            super.onScrolled(recyclerView, dx, dy)
//            if(dy>0){
//                val visibleItemCount: Int = manager.getChildCount()
//                val totalItemCount: Int = manager.getItemCount() //得到list的总数量
//
//                val pastVisiblesItems: Int =
//                    manager.findFirstVisibleItemPosition() //得到显示屏内的第一个list的位置数position
//                if((visibleItemCount + pastVisiblesItems) >= totalItemCount){
//                    viewModel.page.value= viewModel.page.value?.plus(50)
//                    viewModel.apply {
//                        songsheet_list.observe(this@Gedansquare2, Observer {
//                            Log.d("list",it.playlists[0].name)
//                        })
//                    }.get(param1.toString())
//                    Log.d("rv","加载分页")
//                }
//
//            }
//        }
//
//        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
//            super.onScrollStateChanged(recyclerView, newState)
//            if(!binding.rv.canScrollVertically(1)){
//
//
//                val visibleItemCount: Int = manager.getChildCount()
//                val totalItemCount: Int = manager.getItemCount() //得到list的总数量
//
//                val pastVisiblesItems: Int =
//                    manager.findFirstVisibleItemPosition() //得到显示屏内的第一个list的位置数position
//                if((visibleItemCount + pastVisiblesItems) >= totalItemCount){
//
//                   initdata(manager)
//                    Log.d("rv","加载分页")
//                }
//            }
//        }
//    }
}

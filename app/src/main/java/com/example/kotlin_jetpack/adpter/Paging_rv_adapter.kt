package com.example.kotlin_jetpack.adpter

import android.annotation.SuppressLint
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_jetpack.Api.ApiService
import com.example.kotlin_jetpack.R

import com.example.kotlin_jetpack.bean.SongSheetList_Bean
import com.example.kotlin_jetpack.bean.SongSheet_List_Bean
import com.example.kotlin_jetpack.ui.ui.Play_Music
import com.lzx.starrysky.SongInfo
import com.lzx.starrysky.StarrySky


class Paging_rv_adapter: PagingDataAdapter<SongSheet_List_Bean.Song, Paging_rv_adapter.ViewHolder>(object :
    DiffUtil.ItemCallback<SongSheet_List_Bean.Song>(){
    override fun areItemsTheSame(oldItem: SongSheet_List_Bean.Song, newItem: SongSheet_List_Bean.Song): Boolean {
        return oldItem.id==newItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: SongSheet_List_Bean.Song, newItem: SongSheet_List_Bean.Song): Boolean {
       return oldItem==newItem
    }

})

{
    private val playerController= StarrySky.with()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataBean = getItem(position)
        if (dataBean != null) {

            holder.name.text=dataBean.name
            holder.id.text=(position+1).toString()
            val test= dataBean.ar[0].name +" / " + if (dataBean.ar.size==2)dataBean.ar[1].name else null
            holder.songname.text=test
            holder.itemView.setOnClickListener {
                val info = SongInfo()
                info.songId= dataBean.id.toString()
                info.songUrl= ApiService.SONG_URL+dataBean.id+".mp3"
                info.songName=dataBean.name
                info.artist=test
                info.songCover=dataBean.al.picUrl

                if(playerController.getPlayList().isEmpty()){
                    playerController.playMusicByInfo(info)

                    val intent=Intent(it.context,Play_Music::class.java)
                    it.context.startActivity(intent)
                }else{
                    playerController.addSongInfo(0,info)
                    if(playerController.isPlaying()){

                        playerController.skipToNext()
                    }else if (!playerController.isPlaying()){

                        playerController.skipToNext()
                    }
                    val intent=Intent(it.context,Play_Music::class.java)
                    it.context.startActivity(intent)

                    for (app in playerController.getPlayList() ){
                        Log.d("for",app.songName)
                    }
                }

            }
//            if (mOnItemClickListener != null) {
//
//
//            holder.  itemView.setOnClickListener(object : View.OnClickListener {
//                    override fun onClick(p0: View?) {
//                        val position = holder.layoutPosition
//                        mOnItemClickListener!!.onClick(holder.itemView,position,dataBean.id)
//                    }
//                })
//            }



        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sheet_rv, parent, false)
        return ViewHolder(view)

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.textView16)
        val id: TextView = itemView.findViewById(R.id.textView15)
        val songname:TextView=itemView.findViewById(R.id.tv_songname)
    }

    private var mOnItemClickListener: OnRecyItemClickListener? = null
    fun setOnItemClickListener(onItemClickListener: OnRecyItemClickListener) {
        mOnItemClickListener = onItemClickListener
    }


}
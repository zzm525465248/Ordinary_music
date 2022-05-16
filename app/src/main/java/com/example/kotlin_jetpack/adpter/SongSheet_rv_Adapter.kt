package com.example.kotlin_jetpack.adpter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlin_jetpack.R
import com.example.kotlin_jetpack.bean.SongSheetList_Bean
import com.example.kotlin_jetpack.ui.song_list.Song_list
import com.google.android.material.imageview.ShapeableImageView
import com.lzx.starrysky.utils.KtPreferences.Companion.context
import kotlin.math.log

class SongSheet_rv_Adapter :PagingDataAdapter<SongSheetList_Bean.Playlists,SongSheet_rv_Adapter.ViewHolder>(object :DiffUtil.ItemCallback<SongSheetList_Bean.Playlists>(){
    override fun areItemsTheSame(
        oldItem: SongSheetList_Bean.Playlists,
        newItem: SongSheetList_Bean.Playlists
    ): Boolean {

        return oldItem.id==newItem.id
    }

    override fun areContentsTheSame(
        oldItem: SongSheetList_Bean.Playlists,
        newItem: SongSheetList_Bean.Playlists
    ): Boolean {
        return oldItem==newItem
    }

}){

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.tv_name)
        val bf: TextView = itemView.findViewById(R.id.textView3)
        val imag:ShapeableImageView=itemView.findViewById(R.id.imag)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataBean = getItem(position)

        if(dataBean!=null){
            holder.name.text=dataBean.name
            holder.bf.text=(dataBean.playCount/10000).toString()+"万"
            Glide.with(context!!).load(dataBean.coverImgUrl).into(holder.imag)

        }
        holder.itemView.setOnClickListener {
            val intent= Intent(context, Song_list::class.java)
            intent.putExtra("id",dataBean?.id)
            context?.startActivity(intent)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_test, parent, false)
        return ViewHolder(view)
    }
}
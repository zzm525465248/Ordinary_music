package com.example.kotlin_jetpack.adpter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingData
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlin_jetpack.R
import com.example.kotlin_jetpack.adpter.SongReview_rv_Adapter.ViewHolder
import com.example.kotlin_jetpack.bean.Review_song_Bean
import com.example.kotlin_jetpack.bean.SongSheetList_Bean
import com.google.android.material.imageview.ShapeableImageView
import com.lzx.starrysky.utils.KtPreferences.Companion.context

class SongReview_rv_Adapter :PagingDataAdapter<Review_song_Bean.Comment, ViewHolder>(object :DiffUtil.ItemCallback<Review_song_Bean.Comment>(){
    override fun areItemsTheSame(oldItem: Review_song_Bean.Comment, newItem: Review_song_Bean.Comment): Boolean {
        return oldItem.user.userId==newItem.user.userId
    }

    override fun areContentsTheSame(oldItem: Review_song_Bean.Comment, newItem: Review_song_Bean.Comment): Boolean {
            return oldItem==newItem
    }
}

) {



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val name: TextView = itemView.findViewById(R.id.textView32)
        val date: TextView = itemView.findViewById(R.id.textView33)
        val nr: TextView = itemView.findViewById(R.id.textView34)
        val hf: TextView = itemView.findViewById(R.id.textView35)
        val vip: ImageView = itemView.findViewById(R.id.vip_imag)
        val imag: ShapeableImageView =itemView.findViewById(R.id.shapeableImageView4)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataBean = getItem(position)
        if(dataBean!=null){
            holder.name.text=dataBean.user.nickname
            holder.date.text=dataBean.timeStr
            holder.nr.text=dataBean.content
            Glide.with(context!!).load(dataBean.user.avatarUrl).into(holder.imag)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.review_song_view, parent, false)
        return SongReview_rv_Adapter.ViewHolder(view)
    }
}
package com.example.kotlin_jetpack.adpter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlin_jetpack.R
import com.example.kotlin_jetpack.bean.Results
import com.example.kotlin_jetpack.ui.song_list.Song_list


class SongListAdapter :RecyclerView.Adapter<SongListAdapter.ViewHoldr>() {
    private val mlist= arrayListOf<Results>()
    class ViewHoldr(itemview:View) :RecyclerView.ViewHolder(itemview) {
        val name: TextView = itemView.findViewById(R.id.tv_name)
        val id: TextView = itemView.findViewById(R.id.textView3)
        val imag: ImageView =itemView.findViewById(R.id.imag)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHoldr {
        val  itemview=  LayoutInflater.from(parent.context).inflate(R.layout.rv_test,parent,false)

       return ViewHoldr(itemview)
    }

    override fun onBindViewHolder(holder: ViewHoldr, position: Int) {
        holder.itemView.apply {
            with(mlist[position]){
             holder.name.text=name
                holder.id.text=(playCount/10000).toString()+"万"
                Glide.with(context).load(picUrl).into(holder.imag)

                holder.imag.setOnClickListener {
                    Log.d("sheet_id",id.toString())
                    val intent=Intent(context,Song_list::class.java)
                    intent.putExtra("id",id)
                    context.startActivity(intent)
                }
            }

        }
    }

    override fun getItemCount(): Int {
      return mlist.size
    }

    fun setData(it: List<Results>?) {
        mlist.clear()
        if (it != null) {
            mlist.addAll(it)
        }
        notifyDataSetChanged()
    }
}
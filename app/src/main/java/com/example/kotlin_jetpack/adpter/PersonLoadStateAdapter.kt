package com.example.kotlin_jetpack.adpter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_jetpack.databinding.FragmentPagingLoadStateBinding
import com.example.kotlin_jetpack.ui.song_list.Gedansquare2
import com.google.android.exoplayer2.C

class PersonLoadStateAdapter(private val context: Context?) :LoadStateAdapter<PersonLoadStateAdapter.ViewHolder>() {
    class ViewHolder(val binding: FragmentPagingLoadStateBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: ViewHolder, loadState: LoadState) {
        when(loadState){
            is LoadState.Loading -> holder.binding.textView28.text="加载中...."
            is LoadState.NotLoading ->holder.binding.textView28.text="加载完成!"
            is LoadState.Error ->holder.binding.textView28.text="加载失败!"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): ViewHolder {
        return ViewHolder(
            FragmentPagingLoadStateBinding.inflate(
                LayoutInflater.from(context), parent, false
            )
        )


    }
}
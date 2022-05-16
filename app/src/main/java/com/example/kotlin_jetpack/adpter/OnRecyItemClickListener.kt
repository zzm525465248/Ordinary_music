package com.example.kotlin_jetpack.adpter

import android.view.View

interface OnRecyItemClickListener {
    fun onClick(view: View?, position: Int, id: Int)
}
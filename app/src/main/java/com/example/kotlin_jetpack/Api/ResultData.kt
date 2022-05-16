package com.example.kotlin_jetpack.Api

import android.util.Log

data class ResultData<T>(
    val code:Int,
    val data:T,
    val success:Boolean,
    val message:String

){
    companion object{
        const val code1=10000

    }

}

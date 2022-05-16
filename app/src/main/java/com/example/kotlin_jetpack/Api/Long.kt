package com.example.kotlin_jetpack.Api

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*
import kotlin.Long

    /**
     * 将毫秒转为 00：00：00格式时间。
     */
    @SuppressLint("SimpleDateFormat")
    fun Long.toMinAndSeconds():String{
        val ms: Long = this- TimeZone.getDefault().getRawOffset()
        val formatter = SimpleDateFormat("HH:mm:ss") //初始化Formatter的转换格式。
        return  formatter.format(ms)
    }

package com.example.kotlin_jetpack.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.lzx.starrysky.service.MusicService

class MyService :Service() {

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }
}
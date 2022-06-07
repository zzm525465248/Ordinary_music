package com.example.kotlin_jetpack

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.lzx.starrysky.SongInfo
import com.lzx.starrysky.StarrySky
import com.lzx.starrysky.notification.INotification
import com.lzx.starrysky.notification.NotificationConfig
import java.nio.channels.SelectionKey
import javax.crypto.SecretKey

open class TestApplication :Application() {

    companion object{
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }
    @Override
    override fun onCreate() {
        super.onCreate()
        context=applicationContext
        StarrySky.init(this).setNotificationSwitch(true).connService(true)
            .setDebug(true).isStartService(true).apply()

       // StarrySky.init(this).apply()
    }

}

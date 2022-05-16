package com.example.kotlin_jetpack

import android.app.Application
import com.lzx.starrysky.SongInfo
import com.lzx.starrysky.StarrySky
import com.lzx.starrysky.notification.INotification
import com.lzx.starrysky.notification.NotificationConfig
import java.nio.channels.SelectionKey
import javax.crypto.SecretKey

open class TestApplication :Application() {
    @Override
    override fun onCreate() {
        super.onCreate()
//        StarrySky.init(this).setNotificationSwitch(true).connService(true)
//            .setDebug(true).isStartService(true).apply()

        StarrySky.init(this).apply()
    }

}



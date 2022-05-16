package com.example.kotlin_jetpack.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.kotlin_jetpack.R
import com.example.kotlin_jetpack.databinding.ActivityMain2Binding
import com.gyf.barlibrary.ImmersionBar
import com.lzx.starrysky.SongInfo
import com.lzx.starrysky.StarrySky


class MainActivity_home : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView


        val navController = findNavController(R.id.nav_host_fragment_activity_main2)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
     
        navView.setupWithNavController(navController)
        ImmersionBar.with(this).statusBarDarkFont(true).titleBar(binding.root).init()
    }


}



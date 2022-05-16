package com.example.kotlin_jetpack.ui.Unit

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_jetpack.R
import com.example.kotlin_jetpack.ui.ui.Play_Music
import com.gyf.barlibrary.ImmersionBar

abstract class BaseActivity : AppCompatActivity()  {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityCollector.addActivity(this)
        initBinding()
        initData()
        initView()
        initBroadcastReceiver()
        initListener()
        initObserver()
        initBar()
    }

    protected open fun initBar(){
        ImmersionBar.with(this).init()
    }

    protected open fun initObserver(){}

    protected open fun initListener(){}

    protected open fun initBroadcastReceiver(){}

    protected open fun initView(){}

    protected open fun initData(){}

    protected open fun initBinding(){}
    
    override fun onDestroy() {
        super.onDestroy()

    }


}
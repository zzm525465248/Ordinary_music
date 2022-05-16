package com.example.kotlin_jetpack.ui.Unit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlin_jetpack.R


abstract class BaseFragment : Fragment() {
    open fun initBinding() {}
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
        initData()
        initListener()
        initObserver()
        initBroadcastReceiver()
    }

    open fun initBroadcastReceiver(){}

    open fun initView() {}

    open fun initData() {}

    open fun initListener() {}

    open fun initObserver() {}

}
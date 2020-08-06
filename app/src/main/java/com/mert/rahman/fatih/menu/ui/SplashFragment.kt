package com.mert.rahman.fatih.menu.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mert.rahman.fatih.menu.R
import com.mert.rahman.fatih.menu.base.BaseFragment

class SplashFragment : BaseFragment() {

    private val TAG = "SplashFragment"

    override fun layout(inflater: LayoutInflater, container: ViewGroup?): View {
        return inflater.inflate(R.layout.fragment_splash,container,false)
    }

    override fun destroy() {
    }

    override fun viewCreated(view: View, savedInstanceState: Bundle?) {
        Log.i(TAG,"SplashFragment Launched!")
    }

    override fun destroyView() {
    }
}
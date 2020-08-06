package com.mert.rahman.fatih.menu.base

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.isActive
import java.util.concurrent.CancellationException
import kotlin.coroutines.CoroutineContext

abstract class BaseFragment : Fragment(){
        private var godJob : Job? = Job()
        private var coroutineContext: CoroutineContext = lifecycleScope.coroutineContext + godJob!!


        open fun attach(context: Context){}
        abstract fun layout(inflater: LayoutInflater, container: ViewGroup?): View
        abstract fun destroy()
        abstract fun viewCreated(view: View, savedInstanceState: Bundle?)
        abstract fun destroyView()
        /**
         * Yeni bir lifecycleobserver olusturmak ile sorumlu
         */
        open fun bindLifecycleObserver(){}

        internal open suspend fun whenCreated(){}
        internal open suspend fun whenStarted(){}
        internal open suspend fun whenResumed(){}

        init {
            lifecycleScope.launchWhenCreated {
                Log.i("BaseFragment","lifecycleScope.launchWhenCreated Launched")
                whenCreated()
            }
            lifecycleScope.launchWhenStarted {
                Log.i("BaseFragment","lifecycleScope.launchWhenStarted Launched")
                whenStarted()
            }
            lifecycleScope.launchWhenResumed {
                Log.i("BaseFragment","lifecycleScope.launchWhenResumed Launched")
                whenResumed()
            }
        }

        override fun onAttach(context: Context) {
            super.onAttach(context)
            Log.i("BaseFragment","onAttach Launched")
            attach(context)
        }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            bindLifecycleObserver()
        }

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            Log.i("BaseFragment","onCreateView Launched")
            return layout(inflater,container)
        }


        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            Log.i("BaseFragment","onViewCreated Launched")
            viewCreated(view, savedInstanceState)
        }

        override fun onDestroy() {
            super.onDestroy()
            Log.i("BaseFragment","onDestroy Launched")
            destroy()
            if(godJob?.isActive!!){
                godJob!!.cancel("Fragment is destroyed")
            }
            godJob = null
        }

        override fun onDestroyView() {
            super.onDestroyView()
            Log.i("BaseFragment","onDestroyView Launched")
            destroyView()
            if(coroutineContext.isActive)
                coroutineContext.cancel(CancellationException("Coroutine Context Destroyed Because Fragment Was Destroyed"))
        }
}
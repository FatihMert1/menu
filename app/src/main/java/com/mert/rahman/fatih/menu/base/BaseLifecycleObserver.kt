package com.mert.rahman.fatih.menu.base


import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent


/**
 *  Event           State
 * onCreate()   ->  CREATED
 * onStart()    ->  STARTED
 * onPause()    ->  PAUSED
 * onResume()   ->  RESUMED
 * onDestroy()  ->  DESTROYED
 * onStop()     ->  STOPPED
 */
interface IBaseLifecycleObserver : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate(){
        Log.i("IBaseLifecycleObserver", "This Message wrote from IBaseLifecycleObserver onCreate")
        onCreating()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart(){
        Log.i("IBaseLifecycleObserver", "This Message wrote from IBaseLifecycleObserver onStart")
        onStarting()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume(){
        Log.i("IBaseLifecycleObserver", "This Message wrote from IBaseLifecycleObserver onResume")
        onResuming()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause(){
        Log.i("IBaseLifecycleObserver", "This Message wrote from IBaseLifecycleObserver onPause")
        onPausing()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop(){
        Log.i("IBaseLifecycleObserver", "This Message wrote from IBaseLifecycleObserver onStop")
        onStopping()
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy(){
        Log.i("IBaseLifecycleObserver", "This Message wrote from IBaseLifecycleObserver onDestroy")
        onDestroying()
    }

    fun onCreating(){
        Log.i("IBaseLifecycleObserver", "This Message wrote from IBaseLifecycleObserver onCreating")
    }
    fun onStarting(){
        Log.i("IBaseLifecycleObserver", "This Message wrote from IBaseLifecycleObserver onStarting")
    }
    fun onResuming(){
        Log.i("IBaseLifecycleObserver", "This Message wrote from IBaseLifecycleObserver onResuming")
    }
    fun onPausing(){
        Log.i("IBaseLifecycleObserver", "This Message wrote from IBaseLifecycleObserver onPausing")
    }
    fun onStopping(){
        Log.i("IBaseLifecycleObserver", "This Message wrote from IBaseLifecycleObserver onStopping")
    }
    fun onDestroying(){
        Log.i("IBaseLifecycleObserver", "This Message wrote from IBaseLifecycleObserver onDestroying")
    }

}
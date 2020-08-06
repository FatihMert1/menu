package com.mert.rahman.fatih.menu.base

import android.app.Application
import androidx.lifecycle.*
import com.mert.rahman.fatih.menu.handler.CoroutineExHandler
import kotlinx.coroutines.*


open class BaseViewModel : ViewModel(){

    private val handler = CoroutineExHandler.getHandler()
    private val job = Job()
    private val context = job + Dispatchers.IO + handler
    val ioScope = CoroutineScope(context)

    private val info = MutableLiveData<String>()

    fun getInfoData(): LiveData<String> {
        return info
    }

    fun setData(deger:String){
        info.postValue(deger)
    }


    fun createLaunchScope(block:() -> Unit){
        try {
            viewModelScope.launch(ioScope.coroutineContext) {
                block()
            }
        }catch (e:Exception){
            //TODO: empty catch block
        }
    }

    fun createLaunchScope(block: suspend () -> Unit){
        try {
            viewModelScope.launch(ioScope.coroutineContext) {
                block()
            }
        }catch (e:Exception){
            //TODO: empty catch block
        }
    }

}
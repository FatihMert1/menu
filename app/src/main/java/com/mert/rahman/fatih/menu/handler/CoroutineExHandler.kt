package com.mert.rahman.fatih.menu.handler

import kotlinx.coroutines.CoroutineExceptionHandler

class CoroutineExHandler {

    companion object {
        fun getHandler(): kotlinx.coroutines.CoroutineExceptionHandler {
            return CoroutineExceptionHandler { coroutineContext, throwable ->
                //TODO: Empty block
            }
        }
    }
}
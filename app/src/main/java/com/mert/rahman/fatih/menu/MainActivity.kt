package com.mert.rahman.fatih.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mert.rahman.fatih.menu.ui.SplashFragment
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject
import javax.inject.Qualifier
import javax.inject.Singleton

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject lateinit var someClass: SomeClass
    @Inject lateinit var sameTypeClass:SameTypeProvideClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.onboarding_search)

        Log.i("Main",someClass.doAThing())
        Log.i("Main",someClass.doOtherThing())
        Log.i("Main",sameTypeClass.doAThing1())
        Log.i("Main",sameTypeClass.doAThing2())
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.root_activity_main,SplashFragment())
//            .commit()
    }
}


class SomeClass @Inject constructor(private val someOtherClass: SomeOtherClass){

    fun doAThing():String{
        return "Look I did a thing!"
    }

    fun doOtherThing():String{
        return someOtherClass.doOtherThing()
    }

}

class SomeOtherClass @Inject constructor(
    private val someInterfaceImpl1: SomeInterface,
    private val someInterfaceImpl2: SomeInterface
){
    fun doOtherThing():String{
        return "I did a other thing"
    }
}

class SomeInterfaceImpl @Inject constructor(): SomeInterface{
    override fun someMethod(): String {
        return ""
    }

}

class SameTypeProvideClass(
    @Impl1 private val sameTypeProvideImpl1:SameTypeProvidesInterface,
    @Impl2 private val sameTypeProvideImpl2:SameTypeProvidesInterface
){
    fun doAThing1():String{
        return sameTypeProvideImpl1.doAThing()
    }
    fun doAThing2():String{
        return sameTypeProvideImpl2.doAThing()
    }
}

class SomeInterfaceImpl2 @Inject constructor(): SameTypeProvidesInterface{
    override fun doAThing(): String {
        return "A Thing2"
    }
}
class SomeInterfaceImpl1 @Inject constructor(): SameTypeProvidesInterface{
    override fun doAThing(): String {
        return "A Thing2"
    }
}

interface SameTypeProvidesInterface{
    fun doAThing():String
}

interface SomeInterface{
    fun someMethod():String
}

@InstallIn(ApplicationComponent::class)
@Module
 class Module{

    @ActivityScoped
    @Provides
    fun provideSomeInterface(): SomeInterface{
        return SomeInterfaceImpl()
    }
}

@InstallIn(ApplicationComponent::class)
@Module
class SameTypeProvideModule(){
    @Impl1
    @Singleton
    @Provides
    fun  provideSomeInterfaceImpl1():SameTypeProvidesInterface{
        return SomeInterfaceImpl1()
    }

    @Impl2
    @Singleton
    @Provides
    fun  provideSomeInterfaceImpl2():SameTypeProvidesInterface{
        return SomeInterfaceImpl2()
    }
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Impl1

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Impl2

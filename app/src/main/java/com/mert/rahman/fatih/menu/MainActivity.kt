package com.mert.rahman.fatih.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mert.rahman.fatih.menu.ui.SplashFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportFragmentManager.beginTransaction()
            .replace(R.id.root_activity_main,SplashFragment())
            .commit()
    }
}
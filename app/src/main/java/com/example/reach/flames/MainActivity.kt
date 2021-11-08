package com.example.reach.flames

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Handler(Looper.getMainLooper()).postDelayed({
            val homeintent = Intent(this@MainActivity, Main2Activity::class.java)
            startActivity(homeintent)
            finish()
        }, SPLASH_TIME_OUT.toLong())

    }

    companion object {
        private const val SPLASH_TIME_OUT = 2500
    }
}
package com.sananismayilov.finalproject.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.sananismayilov.finalproject.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val handler = Handler()
        handler.postDelayed(Runnable {
            val intent = Intent(this@MainActivity, LoginandRegisterActivity::class.java)
            startActivity(intent)
            finish()
        }, 4000)
    }
}
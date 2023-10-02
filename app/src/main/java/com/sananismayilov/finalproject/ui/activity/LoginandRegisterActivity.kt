package com.sananismayilov.finalproject.ui.activity

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sananismayilov.finalproject.databinding.ActivityLoginandRegisterBinding
import com.sananismayilov.finalproject.util.Util.PrefName

class LoginandRegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginandRegisterBinding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginandRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = this.getSharedPreferences(PrefName, MODE_PRIVATE)
        val status = sharedPreferences.getBoolean("UserStatus", false)
        if (status) {
            val intent = Intent(this, FoodActivity::class.java)
            startActivity(intent)
            finish()
        }

    }


}
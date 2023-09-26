package com.sananismayilov.finalproject.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sananismayilov.finalproject.R
import com.sananismayilov.finalproject.databinding.ActivityLoginandRegisterBinding

class LoginandRegisterActivity : AppCompatActivity() {
    lateinit var binding : ActivityLoginandRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginandRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnlogin.setOnClickListener{
            val intent = Intent(this@LoginandRegisterActivity,FoodActivity::class.java)
            startActivity(intent)
        }

        binding.btnsignup.setOnClickListener{
            val intent = Intent(this@LoginandRegisterActivity,FoodActivity::class.java)
            startActivity(intent)
        }
    }



}
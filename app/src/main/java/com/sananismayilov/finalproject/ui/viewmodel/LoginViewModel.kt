package com.sananismayilov.finalproject.ui.viewmodel

import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sananismayilov.finalproject.retrofit.RetrofitUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.math.log

class LoginViewModel : ViewModel() {
    val loginstatus = MutableLiveData<Boolean>()

    fun login(user_email: String, user_password: String) {
        try {


            CoroutineScope(Dispatchers.Main).launch {
                val response =
                    RetrofitUtils.getInstance().insertUserLogin(user_email, user_password)
                if (response.isSuccessful) {
                    if (response.body()?.success == 1) {
                        loginstatus.value = true


                    } else {
                        loginstatus.value = false
                    }
                    println("ResponsE   ${response.body()?.message.toString()}")
                }
            }
        } catch (e: Exception) {
            println("Error1 ${e.localizedMessage}")
        }

    }
}
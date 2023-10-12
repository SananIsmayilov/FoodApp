package com.sananismayilov.finalproject.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sananismayilov.finalproject.retrofit.RetrofitApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(val retrofitApi: RetrofitApi) : ViewModel() {
    val loginstatus = MutableLiveData<Boolean>()
    val loginloading = MutableLiveData<Boolean>(false)

    fun login(user_email: String, user_password: String) {
        loginloading.value = true
        try {

            CoroutineScope(Dispatchers.Main).launch {
                val response =
                    retrofitApi.insertUserLogin(user_email, user_password)
                if (response.isSuccessful) {
                    if (response.body()?.success == 1) {
                        loginstatus.value = true
                    } else {
                        loginloading.value = false
                    }

                }
            }
        } catch (e: Exception) {
            println("Error1 ${e.localizedMessage}")
        }

    }
}
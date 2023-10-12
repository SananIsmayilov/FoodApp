package com.sananismayilov.finalproject.ui.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sananismayilov.finalproject.data.UserResponse
import com.sananismayilov.finalproject.retrofit.RetrofitApi
import com.sananismayilov.finalproject.roomdatabase.ProductDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(val retrofitApi: RetrofitApi) : ViewModel() {
    val Userlist = MutableLiveData<UserResponse>()
    val userdeletestatus = MutableLiveData<Boolean>(false)

    fun getUser(user_email: String) {
        CoroutineScope(Dispatchers.Main).launch {
            val response = retrofitApi.getUser(user_email)
            if (response.isSuccessful) {
                if (response.body()?.success == 1) {
                    Userlist.value = response.body()
                }
            }
        }
    }

    fun deletecart(context: Context) {
        CoroutineScope(Dispatchers.IO).launch {
            ProductDatabase(context).getDao().deleteCart()
        }
    }

    fun deleteUser(user_email: String) {
        CoroutineScope(Dispatchers.Main).launch {
            val response = retrofitApi.deleteUser(user_email)
            if (response.isSuccessful) {
                if (response.body()?.success == 1) {
                    userdeletestatus.value = true
                }
            }
        }
    }


}
package com.sananismayilov.finalproject.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sananismayilov.finalproject.data.DrinkResponse
import com.sananismayilov.finalproject.data.FoodResponse
import com.sananismayilov.finalproject.retrofit.RetrofitApi
import com.sananismayilov.finalproject.retrofit.RetrofitUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val retrofitApi: RetrofitApi) : ViewModel() {
    val foodlist = MutableLiveData<FoodResponse>()
    val drinklist = MutableLiveData<DrinkResponse>()

    fun getFood() {
        CoroutineScope(Dispatchers.Main).launch {
            val response = retrofitApi.getFood()

            if (response.isSuccessful) {
                if (response.body()?.success == 1) {
                    foodlist.value = response.body()
                }
            }
        }
    }


    fun getDrink() {
        CoroutineScope(Dispatchers.Main).launch {
            val response = retrofitApi.getDrink()
            if (response.isSuccessful) {
                if (response.body()?.success == 1) {
                    drinklist.value = response.body()
                }
            }

        }
    }
}
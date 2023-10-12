package com.sananismayilov.finalproject.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sananismayilov.finalproject.data.FoodResponse
import com.sananismayilov.finalproject.retrofit.RetrofitApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailFoodViewModel @Inject constructor(val retrofitApi: RetrofitApi) : ViewModel() {
    val foodlist = MutableLiveData<FoodResponse>()

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

    fun getSearchFood(food_name : String) {
        CoroutineScope(Dispatchers.Main).launch {
            val response = retrofitApi.getSearchFood(food_name)
            if (response.isSuccessful) {
                if (response.body()?.success == 1) {
                    foodlist.value = response.body()
                }
            }
        }
    }

}
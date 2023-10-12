package com.sananismayilov.finalproject.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sananismayilov.finalproject.data.DrinkResponse
import com.sananismayilov.finalproject.retrofit.RetrofitApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailDrinkViewModel @Inject constructor(val retrofitApi: RetrofitApi) : ViewModel() {
    val drinklist = MutableLiveData<DrinkResponse>()

    fun getDrink(){
        CoroutineScope(Dispatchers.Main).launch {
            val response = retrofitApi.getDrink()
            if(response.isSuccessful){
                if (response.body()?.success == 1){
                    drinklist.value = response.body()
                }
            }
        }
    }

    fun getsearchDrink(drink_name : String){
        CoroutineScope(Dispatchers.Main).launch {
            val response = retrofitApi.getSearchDrink(drink_name)
            if(response.isSuccessful){
                if (response.body()?.success == 1){
                    drinklist.value = response.body()
                }
            }
        }
    }

}
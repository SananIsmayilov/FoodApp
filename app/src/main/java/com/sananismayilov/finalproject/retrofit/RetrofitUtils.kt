package com.sananismayilov.finalproject.retrofit

import com.sananismayilov.finalproject.util.Util.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitUtils {

    companion object {
        @Volatile
        private var instance: RetrofitApi? = null

        @Synchronized
        fun getInstance(): RetrofitApi {
            if (instance == null) {
                instance = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(RetrofitApi::class.java)

            }
            return instance as RetrofitApi
        }


    }

}
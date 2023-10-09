package com.sananismayilov.finalproject.retrofit

import com.sananismayilov.finalproject.data.CrudResponse
import com.sananismayilov.finalproject.data.DrinkResponse
import com.sananismayilov.finalproject.data.FoodResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitApi {
    @FormUrlEncoded
    @POST("/FinalProject/FinalProjectUsers/insert.php")
    suspend fun insertUserssignUp(
        @Field("user_name") user_name: String,
        @Field("user_surname") user_surname: String,
        @Field("user_email") user_email: String,
        @Field("user_password") user_password: String,
        @Field("user_phonenumber") user_phonenumber: String,
        @Field("user_city") user_city: String,
        @Field("user_adress") user_adress: String
    ): Response<CrudResponse>


    @FormUrlEncoded
    @POST("/FinalProject/FinalProjectUsers/loginuser.php")
    suspend fun insertUserLogin(
        @Field("user_email") user_email1: String,
        @Field("user_password") user_password1: String
    ): Response<CrudResponse>


    @GET("/FinalProject/Foods/getFood.php")
    suspend fun getFood(): Response<FoodResponse>

    @GET("/FinalProject/Drinks/getDrink.php")
    suspend fun getDrink(): Response<DrinkResponse>

    @FormUrlEncoded
    @POST("/FinalProject/Drinks/getSearchDrink.php")
    suspend fun getSearchDrink(@Field("drink_name") drink_name: String): Response<DrinkResponse>

    @FormUrlEncoded
    @POST("/FinalProject/Foods/getSearchFood.php")
    suspend fun getSearchFood(@Field("food_name") food_name: String): Response<FoodResponse>


}
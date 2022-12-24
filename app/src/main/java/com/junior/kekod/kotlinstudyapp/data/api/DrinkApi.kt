package com.junior.kekod.kotlinstudyapp.data.api

import com.junior.kekod.kotlinstudyapp.data.dto.DrinkResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface DrinkApi {

    @GET("search.php")
    suspend fun getDrinksWithFirstLetter(@Query("f") firstLetter: String): DrinkResponse
}
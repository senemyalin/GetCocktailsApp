package com.junior.kekod.kotlinstudyapp.data.source

import com.junior.kekod.kotlinstudyapp.data.NetworkResponse
import com.junior.kekod.kotlinstudyapp.data.api.DrinkApi
import com.junior.kekod.kotlinstudyapp.data.dto.Drink
import java.lang.Exception
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val drinkApi: DrinkApi): RemoteDataSource{

    override suspend fun getDrinksWithFirstLetter(firstLetter: String): NetworkResponse<List<Drink>> =
        try {
            val response = drinkApi.getDrinksWithFirstLetter(firstLetter)
            NetworkResponse.Success(response.drinks)
        }catch (e: Exception){
            NetworkResponse.Error(e)
        }
}
package com.junior.kekod.kotlinstudyapp.data.source

import com.junior.kekod.kotlinstudyapp.data.NetworkResponse
import com.junior.kekod.kotlinstudyapp.data.api.DrinkApi
import com.junior.kekod.kotlinstudyapp.data.dto.Drink
import java.lang.Exception
import javax.inject.Inject

interface RemoteDataSource{

    suspend fun getDrinksWithFirstLetter(firstLetter: String): NetworkResponse<List<Drink>>

}
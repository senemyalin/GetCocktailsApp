package com.junior.kekod.kotlinstudyapp.data.repository

import com.junior.kekod.kotlinstudyapp.data.NetworkResponse
import com.junior.kekod.kotlinstudyapp.data.dto.Drink

interface DrinkRepository {

    suspend fun getDrinksWithFirstLetter(firstLetter: String): NetworkResponse<List<Drink>>

}
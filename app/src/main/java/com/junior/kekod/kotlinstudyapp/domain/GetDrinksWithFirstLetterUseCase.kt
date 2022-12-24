package com.junior.kekod.kotlinstudyapp.domain

import com.junior.kekod.kotlinstudyapp.data.NetworkResponse
import kotlinx.coroutines.flow.Flow

interface GetDrinksWithFirstLetterUseCase {

    operator fun invoke(firstLetter: String): Flow<NetworkResponse<List<DrinkEntity>>>
}
package com.junior.kekod.kotlinstudyapp.domain

import com.junior.kekod.kotlinstudyapp.data.NetworkResponse
import com.junior.kekod.kotlinstudyapp.data.dto.Drink
import com.junior.kekod.kotlinstudyapp.data.repository.DrinkRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetDrinksWithFirstLetterUseCaseImpl @Inject constructor(
    private val drinkRepository: DrinkRepository,
    private val drinkListMapper: DrinkListMapper<Drink, DrinkEntity>
) : GetDrinksWithFirstLetterUseCase {

    override operator fun invoke(firstLetter: String): Flow<NetworkResponse<List<DrinkEntity>>> =
        flow {
            emit(NetworkResponse.Loading)

            when(val response = drinkRepository.getDrinksWithFirstLetter(firstLetter)){
                is NetworkResponse.Error -> emit(response)
                NetworkResponse.Loading -> TODO()
                is NetworkResponse.Success -> emit(NetworkResponse.Success(drinkListMapper.map(response.result)))
            }
        }
}
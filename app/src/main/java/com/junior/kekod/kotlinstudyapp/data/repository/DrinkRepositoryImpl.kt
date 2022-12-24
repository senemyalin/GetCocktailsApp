package com.junior.kekod.kotlinstudyapp.data.repository

import com.junior.kekod.kotlinstudyapp.data.NetworkResponse
import com.junior.kekod.kotlinstudyapp.data.dto.Drink
import com.junior.kekod.kotlinstudyapp.data.source.RemoteDataSource
import com.junior.kekod.kotlinstudyapp.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class DrinkRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) :
    DrinkRepository {

    override suspend fun getDrinksWithFirstLetter(firstLetter: String): NetworkResponse<List<Drink>> =
        withContext(ioDispatcher) {
            try {
                remoteDataSource.getDrinksWithFirstLetter(firstLetter)
            } catch (e: Exception) {
                NetworkResponse.Error(e)
            }
        }

}
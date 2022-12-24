package com.junior.kekod.kotlinstudyapp.di

import com.junior.kekod.kotlinstudyapp.data.repository.DrinkRepository
import com.junior.kekod.kotlinstudyapp.data.repository.DrinkRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class DrinkRepositoryModule{

    @Binds
    @ViewModelScoped
    abstract fun bindDrinkRepository(drinkRepositoryImpl: DrinkRepositoryImpl): DrinkRepository

}
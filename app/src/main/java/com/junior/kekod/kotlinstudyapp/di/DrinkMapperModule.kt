package com.junior.kekod.kotlinstudyapp.di

import com.junior.kekod.kotlinstudyapp.data.dto.Drink
import com.junior.kekod.kotlinstudyapp.data.repository.DrinkRepository
import com.junior.kekod.kotlinstudyapp.domain.DrinkDomainListMapperImpl
import com.junior.kekod.kotlinstudyapp.domain.DrinkEntity
import com.junior.kekod.kotlinstudyapp.domain.DrinkListMapper
import com.junior.kekod.kotlinstudyapp.ui.home.DrinkHomeUiMapperImpl
import com.junior.kekod.kotlinstudyapp.ui.home.HomeUiData
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class DrinkMapperModule {

    @Binds
    @ViewModelScoped
    abstract fun bindDrinkDomainListMapper(drinkDomainListMapperImpl: DrinkDomainListMapperImpl): DrinkListMapper<Drink, DrinkEntity>

    @Binds
    @ViewModelScoped
    abstract fun bindDrinkHomeUiMapper(drinkHomeUiMapperImpl: DrinkHomeUiMapperImpl): DrinkListMapper<DrinkEntity, HomeUiData>

}
package com.junior.kekod.kotlinstudyapp.ui.home

import com.junior.kekod.kotlinstudyapp.data.dto.Drink
import com.junior.kekod.kotlinstudyapp.domain.DrinkEntity
import com.junior.kekod.kotlinstudyapp.domain.DrinkListMapper
import javax.inject.Inject

class DrinkHomeUiMapperImpl @Inject constructor() : DrinkListMapper<DrinkEntity, HomeUiData> {

    override fun map(input: List<DrinkEntity>?): List<HomeUiData> {
        val a = mutableListOf<String?>()

        return input?.map {
            HomeUiData(it.name, it.category, it.videoUrl)
        } ?: emptyList()
    }
}
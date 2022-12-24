package com.junior.kekod.kotlinstudyapp.domain

import com.junior.kekod.kotlinstudyapp.data.dto.Drink
import javax.inject.Inject

class DrinkDomainListMapperImpl @Inject constructor() : DrinkListMapper<Drink,DrinkEntity>{

    override fun map(input: List<Drink>?): List<DrinkEntity> {
         val a = mutableListOf<String?>()

        return input?.map {
            a.clear()
            a.add(it.strIngredient1.orEmpty())
            a.add(it.strIngredient2.orEmpty())
            a.add(it.strIngredient3.orEmpty())
            a.add(it.strIngredient4.orEmpty())
            a.add(it.strIngredient5.orEmpty())
            a.add(it.strIngredient6.orEmpty())
            a.add(it.strIngredient7.orEmpty())
            a.add(it.strIngredient8.orEmpty())
            DrinkEntity(
                name = it.strDrink.orEmpty(),
                category = it.strCategory.orEmpty(),
                videoUrl = it.strVideo.orEmpty(),
                ingredients = a
            )
        } ?: emptyList()
    }
}
package com.junior.kekod.kotlinstudyapp.domain

data class DrinkEntity(
    val name: String,
    val category: String,
    val videoUrl: String,
    val ingredients: MutableList<String?>,
)
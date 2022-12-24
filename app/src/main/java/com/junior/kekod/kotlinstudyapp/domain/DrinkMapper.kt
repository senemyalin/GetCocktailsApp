package com.junior.kekod.kotlinstudyapp.domain

interface DrinkMapper<I, O> {
    fun map(input: I?): O
}
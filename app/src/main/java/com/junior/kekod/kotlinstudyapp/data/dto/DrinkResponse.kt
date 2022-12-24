package com.junior.kekod.kotlinstudyapp.data.dto


import com.google.gson.annotations.SerializedName

data class DrinkResponse(
    @SerializedName("drinks")
    val drinks: List<Drink>?
)
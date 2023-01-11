package com.junior.kekod.kotlinstudyapp.ui.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import com.junior.kekod.kotlinstudyapp.databinding.LayoutDrinkBinding
import com.junior.kekod.kotlinstudyapp.ui.home.HomeUiData

//sadece contextli yapi, attribute setli hali, ve defstyleattrli halini de olusturur verirsen
class DrinkUiComponent @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attributeSet, defStyleAttr) {

    private val binding = LayoutDrinkBinding.inflate(LayoutInflater.from(context), this, false)

    init {
        addView(binding.root)
    }

    fun setDrinkData(homeUiData: HomeUiData){
       binding.drinkName.text = homeUiData.name
    }
}
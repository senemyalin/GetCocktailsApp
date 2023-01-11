package com.junior.kekod.kotlinstudyapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.junior.kekod.kotlinstudyapp.databinding.AdapterDrinkItemBinding
import com.junior.kekod.kotlinstudyapp.utility.inflateAdapterItem

class DrinkRecyclerViewAdapter : RecyclerView.Adapter<DrinkRecyclerViewAdapter.DrinkViewHolder>() {

    private val drinkElements = mutableListOf<HomeUiData>()

    fun updateDrinkElements(newElements: List<HomeUiData>) {
        drinkElements.apply {
            clear()
            addAll(newElements)
            //   notifyDataSetChanged()
            notifyItemRangeChanged(0, this.size)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkViewHolder {
//        val binding =
//            AdapterDrinkItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

//        val binding = parent.inflateAdapterItem(AdapterDrinkItemBinding::inflate)
        return DrinkViewHolder.createFrom(parent)
    }

    override fun onBindViewHolder(holder: DrinkViewHolder, position: Int) {
        holder.bind(drinkElements[position])
    }

    override fun getItemCount(): Int = drinkElements.size

    class DrinkViewHolder(private val binding: AdapterDrinkItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun createFrom(parent: ViewGroup) =
                DrinkViewHolder(parent.inflateAdapterItem(AdapterDrinkItemBinding::inflate))
        }

        fun bind(homeUiData: HomeUiData) {
            binding.drinkComponent.setDrinkData(homeUiData)
        }
    }
}
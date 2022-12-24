package com.junior.kekod.kotlinstudyapp.ui.home

import androidx.annotation.StringRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.junior.kekod.kotlinstudyapp.R
import com.junior.kekod.kotlinstudyapp.data.NetworkResponse
import com.junior.kekod.kotlinstudyapp.domain.DrinkEntity
import com.junior.kekod.kotlinstudyapp.domain.DrinkListMapper
import com.junior.kekod.kotlinstudyapp.domain.GetDrinksWithFirstLetterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import retrofit2.Response.error
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getDrinkWithFirstLetterUseCase: GetDrinksWithFirstLetterUseCase,
    private val drinkListMapper: DrinkListMapper<DrinkEntity, HomeUiData>
) :
    ViewModel() {

    private val _drinkHomeUiState = MutableLiveData<HomeUiState>()
    val drinkHomeUiState: LiveData<HomeUiState> get() = _drinkHomeUiState
    fun getDrinksWithFirstLetter(firstLetter: String) {
        viewModelScope.launch {
            getDrinkWithFirstLetterUseCase(firstLetter).collect {
                when (it) {
                    is NetworkResponse.Error -> {
                        _drinkHomeUiState.postValue(HomeUiState.Error(R.string.error))
                    }
                    NetworkResponse.Loading -> {
                        _drinkHomeUiState.postValue(HomeUiState.Loading)
                    }
                    is NetworkResponse.Success -> {
                        _drinkHomeUiState.postValue(HomeUiState.Success(drinkListMapper.map(it.result)))
                    }
                }
            }
        }
    }
}

sealed class HomeUiState {
    object Loading : HomeUiState()
    data class Success(val data: List<HomeUiData>) : HomeUiState()
    data class Error(@StringRes val message: Int) : HomeUiState()
}

data class HomeUiData(
    val name: String,
    val category: String,
    val videoUrl: String
)
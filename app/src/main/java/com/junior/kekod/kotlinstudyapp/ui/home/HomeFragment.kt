package com.junior.kekod.kotlinstudyapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.junior.kekod.kotlinstudyapp.databinding.FragmentHomeBinding
import com.junior.kekod.kotlinstudyapp.utility.observeTextChanges
import com.junior.kekod.kotlinstudyapp.utility.okWith
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.*

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel by viewModels<HomeViewModel>()

    private val adapter = DrinkRecyclerViewAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater).apply {
            drinkListRecyclerView.adapter = adapter
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeSearchTextChanges()
        observeUiState()
    }

    private fun observeUiState() {
        viewModel.drinkHomeUiState.observe(viewLifecycleOwner){
            when(it){
                is HomeUiState.Error -> {

                }
                HomeUiState.Loading -> {

                }
                is HomeUiState.Success -> {
                    handleSuccessUiState(it.data)
                }
            }
        }
    }
    private fun handleSuccessUiState(data: List<HomeUiData>) {
        adapter.updateDrinkElements(data)
    }

    private fun observeSearchTextChanges() {
        binding.searchEditText.observeTextChanges()
            .filter { it okWith MINIMUM_SEARCH_LENGTH }
            .debounce(SEARCH_DEBOUNCE_TIME_IN_MS)
            .distinctUntilChanged()
            .onEach {
                viewModel.getDrinksWithFirstLetter(it)
            }.launchIn(lifecycleScope)
    }

    companion object {
        private const val MINIMUM_SEARCH_LENGTH = 1
        private const val SEARCH_DEBOUNCE_TIME_IN_MS = 300L
        fun newInstance() = HomeFragment()
    }

}
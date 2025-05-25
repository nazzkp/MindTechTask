package com.example.mindtechtask.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mindtechtask.model.dataClass.Car
import com.example.mindtechtask.model.dataClass.CarBrand
import com.example.mindtechtask.model.dataClass.carBrands
import com.example.mindtechtask.model.dataClass.listOfCars
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn


class MainViewmodel : ViewModel() {

    private val _carBrands = MutableStateFlow<List<CarBrand>>(emptyList())
    val carImages: StateFlow<List<CarBrand>> = _carBrands

    private val selectedBrand = MutableStateFlow("")

    private val searchQuery = MutableStateFlow("")

    val filteredCars: StateFlow<List<Car>> = combine(selectedBrand, searchQuery) { brand, query ->
        listOfCars.filter {
            it.brandName.equals(
                brand,
                ignoreCase = true
            ) && (query.isBlank() || it.title.startsWith(
                query,
                ignoreCase = true
            ))
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    fun selectBrand(brandName: String) {
        selectedBrand.value = brandName
    }


    fun updateSearchQuery(query: String) {
        searchQuery.value = query
    }

    init {
        loadImageUrls()
    }

    private fun loadImageUrls() {
        _carBrands.value = carBrands
    }
}
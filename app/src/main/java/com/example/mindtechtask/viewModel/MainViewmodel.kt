package com.example.mindtechtask.viewModel

import androidx.lifecycle.ViewModel
import com.example.mindtechtask.model.dataClass.Car
import com.example.mindtechtask.model.dataClass.listOfCars
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class MainViewmodel() : ViewModel() {

    private val _carImages = MutableStateFlow<List<Car>>(emptyList())
    val carImages: StateFlow<List<Car>> = _carImages


    init {
        loadImageUrls()
    }

    private fun loadImageUrls() {
        _carImages.value = listOfCars

    }

    fun filterCars(carBrand: String) {
        _carImages.value = if (carBrand.isBlank()) {
            listOfCars
        } else {
            listOfCars.filter {
                it.brandName.contains(carBrand, ignoreCase = true) ||
                        it.color.contains(carBrand, ignoreCase = true)
            }
        }
    }

}
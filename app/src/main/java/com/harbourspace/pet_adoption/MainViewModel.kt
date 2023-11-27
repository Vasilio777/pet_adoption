package com.harbourspace.pet_adoption

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.harbourspace.pet_adoption.data.DogRepository
import com.harbourspace.pet_adoption.model.DogModel

class MainViewModel(
    private val repository: DogRepository
) : ViewModel() {

    fun getDogsFromDatabase(): LiveData<List<DogModel>> {
        return repository.allDogs
    }

    fun addDog(dog: DogModel) {
        repository.insert(dog)
    }
}

class MainViewModelFactory(
    private val repository: DogRepository
) : ViewModel(), ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

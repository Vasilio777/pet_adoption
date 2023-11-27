package com.harbourspace.pet_adoption.data

import androidx.lifecycle.LiveData
import com.harbourspace.pet_adoption.model.DogModel
import com.harbourspace.pet_adoption.repository.DogDAO

class DogRepository(private val dogDao: DogDAO) {

    val allDogs: LiveData<List<DogModel>> = dogDao.getDogs()

    fun insert(dog: DogModel) {
        AppDatabase.databaseWriteExecutor.execute {
            dogDao.insert(dog)
        }
    }
}
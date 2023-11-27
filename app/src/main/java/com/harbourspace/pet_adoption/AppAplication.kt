package com.harbourspace.pet_adoption

import android.app.Application
import com.harbourspace.pet_adoption.data.AppDatabase
import com.harbourspace.pet_adoption.data.DogRepository

class AppApplication: Application() {

    val database by lazy { AppDatabase.getDatabase(this) }

    val repository by lazy { DogRepository(database.dogDao()) }

}
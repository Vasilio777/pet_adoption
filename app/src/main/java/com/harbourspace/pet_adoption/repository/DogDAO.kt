package com.harbourspace.pet_adoption.repository

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.harbourspace.pet_adoption.model.DogModel

@Dao
interface DogDAO {

    @Query("SELECT * FROM dog ORDER BY name ASC")
    fun getDogs(): LiveData<List<DogModel>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(dog: DogModel)

    @Query("DELETE FROM dog")
    fun deleteAll()
}
package com.harbourspace.pet_adoption.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Dog")
class DogModel(
    @PrimaryKey(autoGenerate = false)
    var id: Int,
    @ColumnInfo(name = "breedGroup")
    val breedGroup: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "origin")
    val origin: String
)
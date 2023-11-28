package com.harbourspace.pet_adoption.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Location (
    val city: String,
    val country: String,
    val name: String,
    val position: Position
):Parcelable
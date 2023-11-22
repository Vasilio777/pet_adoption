package com.harbourspace.pet_adoption.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class UnsplashSearch(
    val blur_hash: String,
    val color: String,
    val created_at: String,
    val current_user_collections: @RawValue List<Any>,
    val description: String,
    val height: Int,
    val id: String,
    val liked_by_user: Boolean,
    val likes: Int,
    val links: Links,
    val urls: Urls,
    val user: User,
    val width: Int
): Parcelable
package com.harbourspace.pet_adoption.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UnsplashSearch(
  val results: List<UnsplashItem>,
  val total: Int,
  val total_pages: Int
):Parcelable
package com.harbourspace.pet_adoption.data.cb

import com.harbourspace.pet_adoption.model.UnsplashItem

interface UnsplashResult {

    fun onDataFetchSuccess(images: List<UnsplashItem>)

    fun onDataFetchFailed()
}
package com.harbourspace.pet_adoption.data.cb

import com.harbourspace.pet_adoption.data.UnsplashItem

interface UnsplashResult {

    fun onDataFetchSuccess(images: List<UnsplashItem>)

    fun onImageFetchSuccess(image: UnsplashItem)

    fun onDataFetchFailed()

}
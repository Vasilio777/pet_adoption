package com.harbourspace.pet_adoption

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.harbourspace.pet_adoption.api.UnsplashApiProvider
import com.harbourspace.pet_adoption.data.UnsplashItem
import com.harbourspace.pet_adoption.data.cb.UnsplashResult

class UnsplashViewModel : ViewModel(), UnsplashResult {
    private val _items = MutableLiveData<List<UnsplashItem>>()
    val items: LiveData<List<UnsplashItem>> = _items

    private val _itemDetails = MutableLiveData<UnsplashItem>()
    val itemDetails: LiveData<UnsplashItem> = _itemDetails

    private val provider by lazy {
        UnsplashApiProvider()
    }

    fun getUnsplashImages() {
        provider.fetchPhotos(this)
    }

    fun getUnsplashItemByID() {
        provider.getPhotoByID(this)
    }

    override fun onDataFetchSuccess(images: List<UnsplashItem>) {
        _items.value = images
    }

    override fun onImageFetchSuccess(image: UnsplashItem) {
        _itemDetails.value = image
    }

    override fun onDataFetchFailed() {

    }
}
package com.harbourspace.pet_adoption

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.harbourspace.pet_adoption.api.UnsplashApiProvider
import com.harbourspace.pet_adoption.model.UnsplashItem
import com.harbourspace.pet_adoption.data.cb.UnsplashResult

class UnsplashViewModel : ViewModel(), UnsplashResult {
    private val _items = MutableLiveData<List<UnsplashItem>>()
    val items: LiveData<List<UnsplashItem>> = _items

    val provider by lazy {
        UnsplashApiProvider()
    }
    
    fun getUnsplashImages() {
        provider.fetchPhotos(this)
    }

    fun searchImages(keyword: String) {
        provider.searchImages(keyword, this)
    }

    override fun onDataFetchSuccess(images: List<UnsplashItem>) {
        _items.value = images
    }

    override fun onDataFetchFailed() {

    }
}
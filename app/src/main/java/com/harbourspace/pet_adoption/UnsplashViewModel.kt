package com.harbourspace.pet_adoption

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.harbourspace.pet_adoption.api.UnsplashApiProvider
import com.harbourspace.pet_adoption.data.UnsplashCollection
import com.harbourspace.pet_adoption.data.UnsplashItem
import com.harbourspace.pet_adoption.data.cb.UnsplashResult

class UnsplashViewModel : ViewModel(), UnsplashResult {
    private val _items = MutableLiveData<List<UnsplashItem>>()
    val items: LiveData<List<UnsplashItem>> = _items

    private val _collection = MutableLiveData<List<UnsplashCollection>>()
    val collection: LiveData<List<UnsplashCollection>> = _collection

    private val provider by lazy {
        UnsplashApiProvider()
    }

    fun getUnsplashImages() {
        provider.fetchPhotos(this)
    }

    override fun onDataFetchSuccess(images: List<UnsplashItem>) {
        _items.value = images
    }

    override fun onCollectionsFetchedSuccess() {
        TODO("Not yet implemented")
    }

    override fun onDataFetchFailed() {

    }
}
package com.example.pet_adoption

import com.harbourspace.pet_adoption.UnsplashViewModel
import com.harbourspace.pet_adoption.api.UnsplashApiProvider
import com.harbourspace.pet_adoption.model.UnsplashItem
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ExampleUnitTest {

//    @get:Rule
//    val rule = InstantTaskExecutorRule() // Archi tests!!!!

    private lateinit var viewModel: UnsplashViewModel
    private lateinit var fakeProvider: UnsplashApiProvider

    @Before
    fun setup() {
        fakeProvider = UnsplashApiProvider()
        viewModel = UnsplashViewModel()
        viewModel.items.observeForever { }
        viewModel.provider = fakeProvider
    }

    @Test
    fun testGetUnsplashImages_Success() {
        // Prepare fake success response
        val images = listOf(
            UnsplashItem(width = 100, description = "Image 1"),
            UnsplashItem(width = 200, description = "Image 2")
        )
//        fakeProvider.cb.onDataFetchSuccess(images)

        viewModel.getUnsplashImages()

        assertEquals(images, viewModel.items.value)
    }

    @Test
    fun testSearchImages_Failure() {
//        fakeProvider.setFailureResponse()
        viewModel.searchImages("nature")

        assertEquals(null, viewModel.items.value)
    }

    @After
    fun tearDown() {
        viewModel.items.removeObserver { }
    }
}
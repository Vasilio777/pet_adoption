package com.harbourspace.pet_adoption.api

import com.harbourspace.pet_adoption.model.UnsplashItem
import com.harbourspace.pet_adoption.data.cb.UnsplashResult
import com.harbourspace.pet_adoption.model.UnsplashSearch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

private const val BASE_URL = "https:/api.unsplash.com/"

class UnsplashApiProvider {

    private val retrofit by lazy {

//        val client = OkHttpClient.Builder().addInterceptor()
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create<UnsplashApi>()
    }

    fun fetchPhotos(result: UnsplashResult) {
        retrofit.fetchPhotos().enqueue(object: Callback<List<UnsplashItem>> {
            override fun onResponse(
                call: Call<List<UnsplashItem>>,
                response: Response<List<UnsplashItem>>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    result.onDataFetchSuccess(response.body()!!)
                } else {
                    result.onDataFetchFailed()
                }
            }

            override fun onFailure(call: Call<List<UnsplashItem>>, t: Throwable) {
                result.onDataFetchFailed()
            }

        })
    }

    fun searchImages(keyword: String, cb: UnsplashResult) {
        retrofit.searchPhotos(keyword).enqueue(object : Callback<UnsplashSearch> {
            override fun onResponse(call: Call<UnsplashSearch>, response: Response<UnsplashSearch>) {
                if (response.isSuccessful && response.body() != null) {
                    cb.onDataFetchSuccess(response.body()!!.results)
                } else {
                    cb.onDataFetchFailed()
                }
            }

            override fun onFailure(call: Call<UnsplashSearch>, t: Throwable) {
                cb.onDataFetchFailed()
            }
        })
    }
}
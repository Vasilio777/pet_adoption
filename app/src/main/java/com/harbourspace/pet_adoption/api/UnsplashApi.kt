package com.harbourspace.pet_adoption.api

import com.harbourspace.pet_adoption.data.UnsplashCollection
import com.harbourspace.pet_adoption.data.UnsplashItem
import com.harbourspace.pet_adoption.data.UnsplashSearch
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

private const val AUTHORIZATION_CLIENT_ID = "Client-ID"
private const val ACCESS_KEY = "h2LMo_sbaZEL0zpxUMWpBmTSDkIPbQ6yMvAK9W-ywcA"
interface UnsplashApi {

    @Headers("Authorization: $AUTHORIZATION_CLIENT_ID $ACCESS_KEY")
    @GET("photos")
    fun fetchPhotos(): Call<List<UnsplashItem>>

    @Headers("Authorization: $AUTHORIZATION_CLIENT_ID $ACCESS_KEY")
    @GET("search/photos")
    fun searchPhotos(@Query(value = "query") keyword: String): Call<UnsplashSearch>

    @Headers("Authorization: $AUTHORIZATION_CLIENT_ID $ACCESS_KEY")
    @GET("collections")
    fun fetchCollections(): Call<List<UnsplashCollection>>
}
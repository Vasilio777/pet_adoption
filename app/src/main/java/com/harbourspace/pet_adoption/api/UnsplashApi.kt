package com.harbourspace.pet_adoption.api

import com.harbourspace.pet_adoption.data.UnsplashItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

private const val AUTHORIZATION_CLIENT_ID = "Client-ID"
private const val ACCESS_KEY = "h2LMo_sbaZEL0zpxUMWpBmTSDkIPbQ6yMvAK9W-ywcA"
interface UnsplashApi {

    @Headers("Authorization: $AUTHORIZATION_CLIENT_ID $ACCESS_KEY")
    @GET("photos")
    fun fetchPhotos(): Call<List<UnsplashItem>>

    @Headers("Authorization: $AUTHORIZATION_CLIENT_ID $ACCESS_KEY")
    @GET("/photos/random")
    fun getPhotoByID(): Call<UnsplashItem>
}
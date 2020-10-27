package com.rafaelm.disneymottionsmvvm.network

import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET

interface DisneyService {

    @GET("DisneyPosters.json")
    suspend fun fetchDisneyPosterList(): ApiResponse<List<Poster>>
}

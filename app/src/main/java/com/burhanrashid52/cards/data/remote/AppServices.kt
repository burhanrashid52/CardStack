package com.burhanrashid52.cards.data.remote

import com.burhanrashid52.cards.home.models.MoviesResponse
import retrofit2.Call
import retrofit2.http.GET

interface AppServices {

    @GET("movieslist")
    fun getMovies(): Call<BaseResponse<MoviesResponse>>
}
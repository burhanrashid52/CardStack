package com.burhanrashid52.cards.data.remote

import com.burhanrashid52.cards.home.models.CharacterResponse
import retrofit2.Call
import retrofit2.http.GET

interface AppServices {

    @GET("characterList")
    fun getMovies(): Call<BaseResponse<CharacterResponse>>
}
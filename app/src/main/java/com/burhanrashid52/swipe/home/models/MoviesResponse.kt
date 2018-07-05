package com.burhanrashid52.swipe.home.models

import com.burhanrashid52.swipe.data.remote.BaseResult
import com.google.gson.annotations.SerializedName

data class MoviesResponse(
        @SerializedName("movies") var movies: List<Movies> = emptyList()
) : BaseResult()

data class Movies(

        @field:SerializedName("id")
        val id: Int,

        @field:SerializedName("videoUrl")
        val videoUrl: String = "",

        @field:SerializedName("description")
        val description: String = "",

        @field:SerializedName("title")
        val title: String = "",

        @field:SerializedName("poster")
        val poster: String = "",
        @field:SerializedName("year")
        val year: Int = 0,
        @field:SerializedName("genre")
        val genre: String = "",

        @field:SerializedName("imdb")
        val imdb: String = "",

        @field:SerializedName("duration")
        val duration: String = ""
)
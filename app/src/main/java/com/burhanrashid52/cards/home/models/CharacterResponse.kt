package com.burhanrashid52.cards.home.models

import com.burhanrashid52.cards.data.remote.BaseResult
import com.google.gson.annotations.SerializedName

data class CharacterResponse(
        @SerializedName("characters") var characters: List<Character> = emptyList()
) : BaseResult()

data class Character(

        @field:SerializedName("id")
        val id: Int,

        @field:SerializedName("description")
        val description: String = "",

        @field:SerializedName("title")
        val title: String = "",

        @field:SerializedName("poster")
        val poster: String = ""
)
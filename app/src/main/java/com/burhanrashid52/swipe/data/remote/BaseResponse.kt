package com.burhanrashid52.swipe.data.remote

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(

        @field:SerializedName("result")
        val result: T,

        @field:SerializedName("status")
        val status: Int = 0
)

open class BaseResult {

    @field:SerializedName("message")
    val message: String? = null

    @field:SerializedName("error")
    val error: String? = null
}


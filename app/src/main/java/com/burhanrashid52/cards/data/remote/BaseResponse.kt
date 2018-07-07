package com.burhanrashid52.cards.data.remote

import com.google.gson.annotations.SerializedName

/**
 * Base response to handle error and pre define status codes
 */
data class BaseResponse<out T>(

        @field:SerializedName("result")
        val result: T,

        @field:SerializedName("status")
        val status: Int = 0
)

/**
 * Base result which need to be extended to base response generic class
 */
open class BaseResult {

    @field:SerializedName("message")
    val message: String? = null

    @field:SerializedName("error")
    val error: String? = null
}


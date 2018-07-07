package com.burhanrashid52.cards.data

import com.burhanrashid52.cards.data.remote.BaseResponse
import com.burhanrashid52.cards.data.remote.BaseResult
import ja.burhanrashid52.base.repo.Resource
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.UnknownHostException


/**
 * These a generic callback class to handle the basic errors and messages from a generic foormat
 * API's
 */
class ResponseCallback<T : BaseResult>(private val responseResource: Resource<T>.() -> Unit) : Callback<BaseResponse<T>> {

    override fun onFailure(call: Call<BaseResponse<T>>, t: Throwable) {
        if (t is UnknownHostException) {
            Resource.error("No Internet Available", null).responseResource()
        } else {
            Resource.error(t.message ?: "Something went wrong", null).responseResource()
        }
    }

    override fun onResponse(call: Call<BaseResponse<T>>, response: Response<BaseResponse<T>>) {
        if (response.isSuccessful) {
            if (response.body()?.status in 200..299)
                Resource.success(response.body()?.result).responseResource()
            else
                Resource.error(response.body()?.result?.error, null).responseResource()
        } else {
            response.errorBody()?.let {
                val jsonObject = JSONObject(it.string().toString())
                if (jsonObject.has("result")) {
                    val jsonResult = jsonObject.getJSONObject("result")
                    if (jsonResult.has("message")) {
                        Resource.error(jsonResult.getString("message"), null).responseResource()
                    } else if (jsonResult.has("error")) {
                        Resource.error(jsonResult.getString("error"), null).responseResource()
                    }
                } else {
                    Resource.error(response.message(), null).responseResource()
                }
            } ?: Resource.error(response.message(), null).responseResource()
        }
    }
}

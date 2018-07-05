package com.burhanrashid52.swipe.data

import android.app.Application
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.burhanrashid52.swipe.data.remote.AppServices
import com.burhanrashid52.swipe.home.models.MoviesResponse
import ja.burhanrashid52.base.repo.Resource
import ja.burhanrashid52.base.repo.Status
import javax.inject.Inject

class Repository @Inject constructor(private val webService: AppServices, private val application: Application) {

    fun getMovies(): LiveData<Resource<MoviesResponse>> {
        val mutableLiveData = MutableLiveData<Resource<MoviesResponse>>()
        mutableLiveData.value = Resource.loading(null)
        webService.getMovies().enqueue(ResponseCallback {
            if (status == Status.SUCCESS) {
            }
            mutableLiveData.value = this
        })
        return mutableLiveData
    }
}
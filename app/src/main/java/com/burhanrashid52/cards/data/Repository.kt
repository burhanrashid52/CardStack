package com.burhanrashid52.cards.data

import android.app.Application
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.burhanrashid52.cards.data.remote.AppServices
import com.burhanrashid52.cards.home.models.MoviesResponse
import ja.burhanrashid52.base.repo.Resource
import ja.burhanrashid52.base.repo.Status
import javax.inject.Inject

/**
 * A single [Repository] which follow the repository pattern from which data flow
 * from remote or local
 */
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
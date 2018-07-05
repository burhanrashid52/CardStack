package com.burhanrashid52.swipe.home

import com.burhanrashid52.swipe.App
import com.burhanrashid52.swipe.data.Repository
import com.burhanrashid52.swipe.di.components.DaggerActivityComponent
import ja.burhanrashid52.base.BaseViewModel
import timber.log.Timber
import javax.inject.Inject

/**
 *
 * @author <a href="https://github.com/burhanrashid52">Burhanuddin Rashid</a>
 * @since 7/5/2018
 */
class HomeViewModel : BaseViewModel() {

    @Inject
    lateinit var repository: Repository

    init {
        DaggerActivityComponent.builder()
                .baseNetworkComponent(App.baseNetworkComponent)
                .build()
                .inject(this)
        Timber.e(repository.toString())
    }

    fun fetchMovies()=repository.getMovies()
}
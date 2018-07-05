package com.burhanrashid52.swipe.di.components

import com.burhanrashid52.swipe.di.scopes.AppScope
import com.burhanrashid52.swipe.di.modules.AppComponent
import com.burhanrashid52.swipe.home.HomeViewModel
import dagger.Component
import ja.burhanrashid52.base.di.components.BaseNetworkComponent

/**
 * Created by Burhanuddin Rashid on 3/1/2018.
 */

@AppScope
@Component(dependencies = [BaseNetworkComponent::class], modules = [AppComponent::class])
interface ActivityComponent {
    fun inject(homeViewModel: HomeViewModel)
}


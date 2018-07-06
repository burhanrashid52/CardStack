package com.burhanrashid52.cards

import ja.burhanrashid52.base.BaseApplication
import ja.burhanrashid52.base.di.components.BaseNetworkComponent

class App : BaseApplication() {

    companion object {
        lateinit var baseNetworkComponent: BaseNetworkComponent
    }

    override fun onCreate() {
        super.onCreate()
        baseNetworkComponent = baseDaggerNetworkComponent
    }
}

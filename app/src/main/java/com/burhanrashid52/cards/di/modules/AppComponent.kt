package com.burhanrashid52.cards.di.modules

import com.burhanrashid52.cards.data.remote.AppServices
import com.burhanrashid52.cards.di.scopes.AppScope
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit


/**
 * App level component which provides dependencies of :app module level
 */
@Module
class AppComponent {
    @Provides
    @AppScope
    fun provideRetrofitClient(retrofit: Retrofit) = retrofit.create(AppServices::class.java)!!
}
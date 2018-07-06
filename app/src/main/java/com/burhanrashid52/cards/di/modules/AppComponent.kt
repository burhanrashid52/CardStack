package com.burhanrashid52.cards.di.modules

import com.burhanrashid52.cards.data.remote.AppServices
import com.burhanrashid52.cards.di.scopes.AppScope
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit


@Module
class AppComponent {

    @Provides
    @AppScope
    fun provideRetrofitClient(retrofit: Retrofit) = retrofit.create(AppServices::class.java)!!

    /* @Provides
     @AppScope
     fun provideRoomDB(application: Application): AppDatabase {
         return Room.databaseBuilder(application.applicationContext, AppDatabase::class.java, "movies-db")
                 .fallbackToDestructiveMigration()
                 .build()
     }

     @Provides
     @AppScope
     fun provideMoviesDao(appDatabase: AppDatabase) = appDatabase.moviesDao()*/

}
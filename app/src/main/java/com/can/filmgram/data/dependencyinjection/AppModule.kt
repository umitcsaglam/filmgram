package com.can.filmgram.data.dependencyinjection

import com.can.filmgram.data.remote.MovieAPI
import com.can.filmgram.data.repository.MovieRepositoryImpl
import com.can.filmgram.domain.repository.MovieRepository
import com.can.filmgram.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMovieApi():MovieAPI{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideMovieRepository(api:MovieAPI):MovieRepository{
        return MovieRepositoryImpl(api)
    }



}
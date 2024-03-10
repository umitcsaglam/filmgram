package com.can.filmgram.data.repository

import com.can.filmgram.data.remote.MovieAPI
import com.can.filmgram.data.remote.dto.MovieDetailDto
import com.can.filmgram.data.remote.dto.MoviesDto
import com.can.filmgram.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl  @Inject constructor(private val api:MovieAPI) :MovieRepository {
    override suspend fun getMovies(search: String): MoviesDto {
        return api.getMovies(search)
    }

    override suspend fun getMovieDetail(imdbId: String): MovieDetailDto {
        return api.getMovieDetail(imdbId)
    }
}
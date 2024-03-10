package com.can.filmgram.domain.repository

import com.can.filmgram.data.remote.dto.MovieDetailDto
import com.can.filmgram.data.remote.dto.MoviesDto

interface MovieRepository {
    suspend fun getMovies(search: String):MoviesDto
    suspend fun getMovieDetail(imdbId: String):MovieDetailDto
}
package com.can.filmgram.domain.use_case.get_movie_detail

import com.can.filmgram.data.remote.dto.toMovieDetail
import com.can.filmgram.data.remote.dto.toMovieList
import com.can.filmgram.domain.model.Movie
import com.can.filmgram.domain.model.MovieDetail
import com.can.filmgram.domain.repository.MovieRepository
import com.can.filmgram.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOError
import javax.inject.Inject

class GetMovieDetailUseCse @Inject constructor(private val repository: MovieRepository) {

    fun executeGetMovieDetail(imdbID:String): Flow<Resource<MovieDetail>> = flow {
        try {
            emit(Resource.Loading())
            val movieDetail = repository.getMovieDetail(imdbID)
            emit(Resource.Success(movieDetail.toMovieDetail()))

        }catch (e: IOError){
            emit(Resource.Error("İnternet bağlantısı sağlanamadı"))
        }
    }
}
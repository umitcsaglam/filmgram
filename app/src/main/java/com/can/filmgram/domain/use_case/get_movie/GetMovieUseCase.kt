package com.can.filmgram.domain.use_case.get_movie

import com.can.filmgram.data.remote.dto.toMovieList
import com.can.filmgram.domain.model.Movie
import com.can.filmgram.domain.repository.MovieRepository
import com.can.filmgram.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOError
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(private val repository: MovieRepository) {

    fun executeGetMovies(search:String):Flow<Resource<List<Movie>>> = flow {
        try {
            emit(Resource.Loading())
            val movieList= repository.getMovies(search)
            if (movieList.response.equals("True")){
                emit(Resource.Success(movieList.toMovieList()))
            }else{
                emit(Resource.Error("Film Bulunamadı!"))
            }
        }catch (e:IOError){
            emit(Resource.Error("İnternet bağlantısı sağlanamadı"))
        }
    }
}
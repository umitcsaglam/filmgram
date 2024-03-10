package com.can.filmgram.presentation.movies

import com.can.filmgram.domain.model.Movie

data class MoviesState(
    val isLoading:Boolean = false,
    val movies:List<Movie> = emptyList(),
    val error : String ="",
    val search:String="batman"
)
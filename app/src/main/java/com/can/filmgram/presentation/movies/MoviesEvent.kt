package com.can.filmgram.presentation.movies

sealed class MoviesEvent {
    data class Search(val searchString:String):MoviesEvent()
}
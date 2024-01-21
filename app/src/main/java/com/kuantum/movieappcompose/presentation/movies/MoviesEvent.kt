package com.kuantum.movieappcompose.presentation.movies

sealed class MoviesEvent {
    data class Search(val search: String) : MoviesEvent()
}

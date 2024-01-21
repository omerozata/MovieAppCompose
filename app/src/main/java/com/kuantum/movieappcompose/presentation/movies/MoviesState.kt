package com.kuantum.movieappcompose.presentation.movies

import com.kuantum.movieappcompose.domain.model.Movie

data class MoviesState(
    val isLoading : Boolean = false,
    val movies : List<Movie> = emptyList(),
    val error : String = "",
    val search : String = "spider man"

)

package com.kuantum.movieappcompose.presentation

sealed class Screen(val route: String) {
    object MoviesScreen : Screen("movies_screen")
    object MovieDetailsScreen : Screen("movie_detail_screen")
}
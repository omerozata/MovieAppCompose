package com.kuantum.movieappcompose.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.kuantum.movieappcompose.domain.model.Movie

data class MoviesDto(
    @SerializedName("Response")
    val response: String,
    @SerializedName("Search")
    val search: List<Search>,
    @SerializedName("totalResults")
    val totalResults: String
)

fun MoviesDto.toMovieList() : List<Movie> {
    return search.map { search -> Movie(search.poster, search.title, search.year, search.imdbID) }
}


package com.kuantum.movieappcompose.domain.repository

import com.kuantum.movieappcompose.data.remote.dto.MovieDetailDto
import com.kuantum.movieappcompose.data.remote.dto.MoviesDto

interface MovieRepository {

    suspend fun getMovies(search: String): MoviesDto
    suspend fun getMovieDetail(imdbId: String) : MovieDetailDto

}
package com.kuantum.movieappcompose.data.repository

import com.kuantum.movieappcompose.data.remote.MovieAPI
import com.kuantum.movieappcompose.data.remote.dto.MovieDetailDto
import com.kuantum.movieappcompose.data.remote.dto.MoviesDto
import com.kuantum.movieappcompose.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val api: MovieAPI) : MovieRepository {
    override suspend fun getMovies(search: String): MoviesDto {
        return api.getMovies(search)
    }

    override suspend fun getMovieDetail(imdbId: String): MovieDetailDto {
        return api.getMovieDetail(imdbId)
    }
}
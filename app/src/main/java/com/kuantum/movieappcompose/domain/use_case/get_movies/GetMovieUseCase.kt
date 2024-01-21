package com.kuantum.movieappcompose.domain.use_case.get_movies

import com.kuantum.movieappcompose.data.remote.dto.toMovieList
import com.kuantum.movieappcompose.domain.model.Movie
import com.kuantum.movieappcompose.domain.repository.MovieRepository
import com.kuantum.movieappcompose.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(private val repository: MovieRepository) {

    fun executeGetMovie(search : String) : Flow<Resource<List<Movie>>> = flow {
        try {
            emit(Resource.Loading())
            val movieList = repository.getMovies(search)
            if (movieList.response == "True"){
                emit(Resource.Success(movieList.toMovieList()))
            } else {
                emit(Resource.Error("No data found!"))
            }
        } catch (e : Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Error"))
        }
    }

}
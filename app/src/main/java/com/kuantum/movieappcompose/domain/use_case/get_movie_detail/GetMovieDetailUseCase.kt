package com.kuantum.movieappcompose.domain.use_case.get_movie_detail

import com.kuantum.movieappcompose.data.remote.dto.toMovieDetail
import com.kuantum.movieappcompose.domain.model.MovieDetail
import com.kuantum.movieappcompose.domain.repository.MovieRepository
import com.kuantum.movieappcompose.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(private val repository: MovieRepository) {

    fun executeGetMovieDetail(imdbId : String) : Flow<Resource<MovieDetail>> = flow {
        try {
            emit(Resource.Loading())
            val movieDetail = repository.getMovieDetail(imdbId)
            emit(Resource.Success(movieDetail.toMovieDetail()))
        }catch (e : Exception){
            emit(Resource.Error(e.localizedMessage ?: "Error"))
        }
    }

}
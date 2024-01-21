package com.kuantum.movieappcompose.presentation.movies

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kuantum.movieappcompose.domain.use_case.get_movies.GetMovieUseCase
import com.kuantum.movieappcompose.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val getMovieUseCase: GetMovieUseCase
) : ViewModel() {

    private val _state = mutableStateOf(MoviesState())
    val state : State<MoviesState> = _state

    init {
        getMovies(_state.value.search)
    }

    private var job : Job? = null

    private fun getMovies(search: String) {
        job?.cancel()

        job = getMovieUseCase.executeGetMovie(search).onEach {
            when(it){
                is Resource.Success -> {
                    _state.value = MoviesState(movies = it.data ?: emptyList())
                }

                is Resource.Error -> {
                    _state.value = MoviesState(error = it.message ?: "Error")
                }

                is Resource.Loading -> {
                    _state.value = MoviesState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun onevent(event: MoviesEvent) {
        when(event){
            is MoviesEvent.Search -> {
                getMovies(event.search)
            }
        }
    }

}
package com.kuantum.movieappcompose.presentation.movie_detail.views

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.kuantum.movieappcompose.presentation.movie_detail.MovieDetailViewModel

@Composable
fun MovieDetailScreen(
    movieDetailViewModel: MovieDetailViewModel = hiltViewModel()
) {
    val state = movieDetailViewModel.state.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        state.movie?.let {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = rememberAsyncImagePainter(model = it.poster),
                    contentDescription = it.title,
                    modifier = Modifier
                        .padding(16.dp)
                        .size(400.dp, 400.dp)
                        .clip(RectangleShape)
                )

                Text(
                    text = it.title,
                    modifier = Modifier.padding(14.dp),
                    textAlign = TextAlign.Center,
                    color = Color.White
                )

                Text(
                    text = "Year: ${it.year}",
                    modifier = Modifier.padding(14.dp),
                    textAlign = TextAlign.Center,
                    color = Color.White
                )

                Text(
                    text = "Actors: ${it.actors}",
                    modifier = Modifier.padding(14.dp),
                    textAlign = TextAlign.Center,
                    color = Color.White
                )

                Text(
                    text = "Director: ${it.director}",
                    modifier = Modifier.padding(14.dp),
                    textAlign = TextAlign.Center,
                    color = Color.White
                )

                Text(
                    text = "Rating: ${it.imdbRating}",
                    modifier = Modifier.padding(14.dp),
                    textAlign = TextAlign.Center,
                    color = Color.White
                )
            }
        }

        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(14.dp)
                    .fillMaxWidth()
                    .align(Alignment.Center)
            )
        }

        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }

}
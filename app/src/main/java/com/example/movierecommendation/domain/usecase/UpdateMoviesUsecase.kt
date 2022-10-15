package com.example.movierecommendation.domain.usecase

import com.example.movierecommendation.data.model.movie.Movie
import com.example.movierecommendation.domain.repository.MovieRepository

class UpdateMoviesUsecase(private val movieRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = movieRepository.updateMovie()
}
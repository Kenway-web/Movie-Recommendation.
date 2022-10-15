package com.example.movierecommendation.domain.repository

import com.example.movierecommendation.data.model.movie.Movie

interface MovieRepository {

    // abstract fun , returns a list of movies
    // suspending function as using coroutines.
    suspend fun getMovies(): List<Movie>?

    suspend fun updateMovie(): List<Movie>?


}
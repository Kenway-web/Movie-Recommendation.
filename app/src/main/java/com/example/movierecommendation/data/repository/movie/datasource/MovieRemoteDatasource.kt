package com.example.movierecommendation.data.repository.movie.datasource

import com.example.movierecommendation.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDatasource {
    suspend fun getMovies(): Response<MovieList>
}
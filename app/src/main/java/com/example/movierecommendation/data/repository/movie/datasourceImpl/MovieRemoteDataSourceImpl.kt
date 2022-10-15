package com.example.movierecommendation.data.repository.movie.datasourceImpl

import com.example.movierecommendation.data.api.TMDBService
import com.example.movierecommendation.data.model.movie.MovieList
import com.example.movierecommendation.data.repository.movie.datasource.MovieRemoteDatasource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : MovieRemoteDatasource {

    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)


}
package com.example.movierecommendation.data.repository.movie.datasource

import com.example.movierecommendation.data.model.movie.Movie

interface MovieCacheDataSource {
    // save movies to cache
    suspend fun getMoviesFromCache():List<Movie>
    suspend fun saveMoviesToCache(movies:List<Movie>)
}
package com.example.movierecommendation.data.repository.movie.datasource

import com.example.movierecommendation.data.model.movie.Movie

interface MovieLocalDatasource {

    suspend fun getMoviesFromDB():List<Movie>
    // saving movies to the database
    suspend fun saveMoviesToDB(movies: List<Movie>)
    // clear the data in database table
    suspend fun clearAll()

}
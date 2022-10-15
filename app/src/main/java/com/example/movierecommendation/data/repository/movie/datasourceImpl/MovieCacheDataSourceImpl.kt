package com.example.movierecommendation.data.repository.movie.datasourceImpl

import com.example.movierecommendation.data.model.movie.Movie
import com.example.movierecommendation.data.repository.movie.datasource.MovieCacheDataSource

class MovieCacheDataSourceImpl: MovieCacheDataSource {

    private var movieList=ArrayList<Movie>()
    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    // used to assign passed movie list to movielist
    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}
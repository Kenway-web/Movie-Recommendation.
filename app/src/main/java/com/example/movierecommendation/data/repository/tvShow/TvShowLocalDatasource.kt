package com.example.movierecommendation.data.repository.tvShow

import com.example.movierecommendation.data.model.movie.Movie
import com.example.movierecommendation.data.model.tvshow.TvShow

interface TvShowLocalDatasource {

    suspend fun getTvShowsFromDB():List<TvShow>
    // saving movies to the database
    suspend fun saveTvShowsToDB(tvShows: List<TvShow>)
    // clear the data in database table
    suspend fun clearAll()

}
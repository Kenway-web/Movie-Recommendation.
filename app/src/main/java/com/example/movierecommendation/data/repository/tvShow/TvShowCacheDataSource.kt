package com.example.movierecommendation.data.repository.tvShow

import com.example.movierecommendation.data.model.artist.Artist
import com.example.movierecommendation.data.model.movie.Movie
import com.example.movierecommendation.data.model.tvshow.TvShow

interface TvShowCacheDataSource {
    // save movies to cache
    suspend fun getTvShowsFomCache():List<TvShow>
    suspend fun saveTvShowsToCache(tvShowS:List<TvShow>)
}
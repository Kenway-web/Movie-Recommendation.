package com.example.movierecommendation.data.repository.artist.datasource

import com.example.movierecommendation.data.model.artist.Artist
import com.example.movierecommendation.data.model.movie.Movie

interface ArtistCacheDataSource {
    // save movies to cache
    suspend fun getArtistFromCache():List<Artist>
    suspend fun saveArtistToCache(movies:List<Artist>)
}
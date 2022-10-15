package com.example.movierecommendation.data.repository.artist.datasource

import com.example.movierecommendation.data.model.artist.Artist
import com.example.movierecommendation.data.model.movie.Movie

interface ArtistLocalDatasource {

    suspend fun getArtistFromDB():List<Artist>
    // saving Artist to the database
    suspend fun saveArtistToDB(artists: List<Artist>)
    // clear the data in database table
    suspend fun clearAll()

}
package com.example.movierecommendation.data.repository.artist.datasource

import com.example.movierecommendation.data.model.artist.ArtistList
import com.example.movierecommendation.data.model.movie.MovieList
import retrofit2.Response

interface ArtistRemoteDatasource {
    suspend fun getArtists(): Response<ArtistList>
}
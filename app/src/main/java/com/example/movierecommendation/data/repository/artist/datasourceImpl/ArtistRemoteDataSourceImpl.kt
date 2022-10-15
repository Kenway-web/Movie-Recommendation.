package com.example.movierecommendation.data.repository.artist.datasourceImpl

import com.example.movierecommendation.data.api.TMDBService
import com.example.movierecommendation.data.model.artist.ArtistList
import com.example.movierecommendation.data.repository.artist.datasource.ArtistRemoteDatasource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : ArtistRemoteDatasource {

    override suspend fun getArtists(): Response<ArtistList> = tmdbService.getPopularArtists(apiKey)


}
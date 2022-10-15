package com.example.movierecommendation.data.repository.artist.datasourceImpl

import com.example.movierecommendation.data.model.artist.Artist
import com.example.movierecommendation.data.repository.artist.datasource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl: ArtistCacheDataSource {

    private var artistList=ArrayList<Artist>()
    override suspend fun getArtistFromCache(): List<Artist> {
       return artistList
    }

    override suspend fun saveArtistToCache(movies: List<Artist>) {
      artistList.clear()
      artistList=ArrayList(artistList)
    }



}
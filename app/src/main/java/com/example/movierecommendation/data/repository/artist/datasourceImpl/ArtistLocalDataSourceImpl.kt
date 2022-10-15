package com.example.movierecommendation.data.repository.artist.datasourceImpl

import com.example.movierecommendation.data.db.ArtistDao
import com.example.movierecommendation.data.model.artist.Artist
import com.example.movierecommendation.data.repository.artist.datasource.ArtistLocalDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val  artistDao:ArtistDao): ArtistLocalDatasource {
    override suspend fun getArtistFromDB(): List<Artist> {
       return artistDao.getArtists()
    }

    override suspend fun saveArtistToDB(artists: List<Artist>) {
       CoroutineScope(Dispatchers.IO).launch {
           artistDao.saveArtists(artists)
       }

    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
           artistDao.deleteAllArtists()
        }
    }
}
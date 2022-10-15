package com.example.movierecommendation.data.repository.artist.datasourceImpl

import android.util.Log
import com.example.movierecommendation.data.model.artist.Artist
import com.example.movierecommendation.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.movierecommendation.data.repository.artist.datasource.ArtistLocalDatasource
import com.example.movierecommendation.data.repository.artist.datasource.ArtistRemoteDatasource
import com.example.movierecommendation.domain.repository.ArtistRepository
import java.lang.Exception

class ArtistRepositoryImpl(
    private val artistRemoteDatasource: ArtistRemoteDatasource,
    private val artistLocalDatasource: ArtistLocalDatasource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {

    override suspend fun getArtist(): List<Artist> {
        return getArtistsFromCache()
    }


    override suspend fun updateArtist(): List<Artist> {
        // get data from api
        // clear from db and local cache
        val newListOfArtists = getArtistsFromAPI()
        artistLocalDatasource.clearAll()
        artistLocalDatasource.saveArtistToDB(newListOfArtists)
        artistCacheDataSource.saveArtistToCache(newListOfArtists)
        return newListOfArtists
    }

    suspend fun getArtistsFromAPI(): List<Artist> {
        lateinit var artistList: List<Artist>

        // getting api inside try block
        try {
            val response = artistRemoteDatasource.getArtists()
            val body = response.body()
            if (body != null) {
                artistList = body.artists
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())

        }

        return artistList
    }

    suspend fun getArtistsFromDB(): List<Artist> {
        lateinit var artistList: List<Artist>

        // getting api inside try block
        try {
            artistList = artistLocalDatasource.getArtistFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        if (artistList.size > 0) {
            return artistList
        } else {
            // if db empty fetch from api
            artistList = getArtistsFromAPI()
            artistLocalDatasource.saveArtistToDB(artistList)
        }
        return artistList
    }

    suspend fun getArtistsFromCache(): List<Artist> {

        lateinit var artistList: List<Artist>

        // getting api inside try block
        try {
            artistList = artistCacheDataSource.getArtistFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        if (artistList.size > 0) {
            return artistList
        } else {
            // if db empty fetch from api
            artistList = getArtistsFromDB()
            artistCacheDataSource.saveArtistToCache(artistList)
        }
        return artistList
    }


}
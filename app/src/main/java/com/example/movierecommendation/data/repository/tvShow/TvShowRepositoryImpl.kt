package com.example.movierecommendation.data.repository.tvShow

import android.util.Log
import com.example.movierecommendation.data.model.movie.Movie
import com.example.movierecommendation.data.model.tvshow.TvShow
import com.example.movierecommendation.data.repository.movie.datasource.MovieCacheDataSource
import com.example.movierecommendation.data.repository.movie.datasource.MovieLocalDatasource
import com.example.movierecommendation.data.repository.movie.datasource.MovieRemoteDatasource
import com.example.movierecommendation.domain.repository.MovieRepository
import com.example.movierecommendation.domain.repository.TvShowRepository
import java.lang.Exception

class TvShowRepositoryImpl(
    private val tvShowRemoteDatasource:TvShowRemoteDatasource,
    private val tvShowLocalDatasource: TvShowLocalDatasource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
) : TvShowRepository {


    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow> {
        // get data from api
        // clear from db and local cache
        val newListOfTvShows=getTvShowsFromAPI()
        tvShowLocalDatasource.clearAll()
        tvShowLocalDatasource.saveTvShowsToDB(newListOfTvShows)
        tvShowCacheDataSource.saveTvShowsToCache(newListOfTvShows)
        return  newListOfTvShows
    }


    suspend fun getTvShowsFromAPI(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        // getting api inside try block
        try {
            val response = tvShowRemoteDatasource.getTvShows()
            val body = response.body()
            if (body != null) {
                tvShowList = body.tvShows
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())

        }

        return tvShowList
    }

    suspend fun getTvShowsFromDB(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        // getting api inside try block
        try {
            tvShowList = tvShowLocalDatasource.getTvShowsFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        if (tvShowList.size > 0) {
            return tvShowList
        } else {
            // if db empty fetch from api
            tvShowList = getTvShowsFromAPI()
            tvShowLocalDatasource.saveTvShowsToDB(tvShowList)
        }
        return tvShowList
    }

    suspend fun getTvShowsFromCache(): List<TvShow> {

        lateinit var tvShowsList: List<TvShow>

        // getting api inside try block
        try {
            tvShowsList = tvShowCacheDataSource.getTvShowsFomCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        if (tvShowsList.size > 0) {
            return tvShowsList
        } else {
            // if db empty fetch from api
            tvShowsList = getTvShowsFromDB()
            tvShowCacheDataSource.saveTvShowsToCache(tvShowsList)
        }
        return tvShowsList
    }



}
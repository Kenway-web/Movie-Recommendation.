package com.example.movierecommendation.data.repository.tvShow

import com.example.movierecommendation.data.db.MovieDao
import com.example.movierecommendation.data.db.TvShowDao
import com.example.movierecommendation.data.model.movie.Movie
import com.example.movierecommendation.data.model.tvshow.TvShow
import com.example.movierecommendation.data.repository.movie.datasource.MovieLocalDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val  tvShowDao:TvShowDao): TvShowLocalDatasource {


    override suspend fun getTvShowsFromDB(): List<TvShow> {
        return  tvShowDao.getTvShows()
    }


    override suspend fun saveTvShowsToDB(tvShows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
           tvShowDao.saveTvShows(tvShows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllTvShows()
        }
    }
}